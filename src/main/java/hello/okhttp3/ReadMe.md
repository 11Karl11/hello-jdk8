
AsyncCall
AsyncCall–实际上是一个Runnable

public abstract class NamedRunnable implements Runnable {
  protected final String name;

  public NamedRunnable(String format, Object... args) {
    this.name = Util.format(format, args);
  }

  @Override public final void run() {
    String oldName = Thread.currentThread().getName();
    Thread.currentThread().setName(name);
    try {
      execute();
    } finally {
      Thread.currentThread().setName(oldName);
    }
  }

  protected abstract void execute();
}
NamedRunnable，继承Runnable的抽象类，根据传入的名称来修改线程名称，抽象出执行任务的execute方法

final class AsyncCall extends NamedRunnable {
    // 其他省略，execute方法式真正执行请求
    @Override protected void execute() {
      boolean signalledCallback = false;
      try {
        Response response = getResponseWithInterceptorChain();
        if (retryAndFollowUpInterceptor.isCanceled()) {
          signalledCallback = true;
          responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
        } else {
          signalledCallback = true;
          responseCallback.onResponse(RealCall.this, response);
        }
      } catch (IOException e) {
        if (signalledCallback) {
          // Do not signal the callback twice!
          Platform.get().log(INFO, "Callback failure for " + toLoggableString(), e);
        } else {
          responseCallback.onFailure(RealCall.this, e);
        }
      } finally {
        client.dispatcher().finished(this);
      }
    }
}
AsyncCall中的execute方法，是请求任务执行的方法，获取相应数据最终也是调用了getResponseWithInterceptorChain方法。

private Response getResponseWithInterceptorChain() throws IOException {
    // Build a full stack of interceptors.
    List<Interceptor> interceptors = new ArrayList<>();
    interceptors.addAll(client.interceptors());
    interceptors.add(retryAndFollowUpInterceptor);
    interceptors.add(new BridgeInterceptor(client.cookieJar()));
    interceptors.add(new CacheInterceptor(client.internalCache()));
    interceptors.add(new ConnectInterceptor(client));
    if (!retryAndFollowUpInterceptor.isForWebSocket()) {
      interceptors.addAll(client.networkInterceptors());
    }
    interceptors.add(new CallServerInterceptor(
        retryAndFollowUpInterceptor.isForWebSocket()));

    Interceptor.Chain chain = new RealInterceptorChain(
        interceptors, null, null, null, 0, originalRequest);
    return chain.proceed(originalRequest);
  }
Dispatcher
原理：

对于异步请求来说，Dispatcher类内部持有一个正在执行(运行中)异步任务的队列和一个等待执行(就绪)异步请求的队列，以及一个线程池
这个线程池，没有常存的核心线程，最多线程数为Integer.MAX_VALUE，线程空闲时存活时间为60秒，而SynchronousQueue #2 是不保存任务的，所以只要把任务添加进去就会执行
OkHttp不是在线程池中维护线程的个数，线程是一直在Dispatcher中直接控制。线程池中的请求都是运行中的请求。这也就是说线程的重用不是线程池控制的，通过源码我们发现线程重用的地方是请求结束的地方finished(AsyncCall call) ，而真正的控制是通过promoteCalls方法， 根据maxRequests和maxRequestsPerHost来调整runningAsyncCalls和readyAsyncCalls，使运行中的异步请求不超过两种最大值，并且如果队列有空闲，将就绪状态的请求归类为运行中
public final class Dispatcher {
  //最大请求数
  private int maxRequests = 64;
  //相同host最大请求数
  private int maxRequestsPerHost = 5;
  //请求执行，懒加载
  private ExecutorService executorService;
  //就绪状态的异步请求队列
  private final Deque<AsyncCall> readyCalls = new ArrayDeque<>();
  //运行中的异步请求队列
  private final Deque<AsyncCall> runningCalls = new ArrayDeque<>();
  //进行中的同步请求，包括那些尚未完成被取消的请求
  private final Deque<Call> executedCalls = new ArrayDeque<>();

  public Dispatcher(ExecutorService executorService) {
    this.executorService = executorService;
  }

  public Dispatcher() {
  }

  public synchronized ExecutorService getExecutorService() {
    if (executorService == null) {
       //corePoolSize 为 0表示，没有核心线程，所有执行请求的线程，使用完了如果过期了（keepAliveTime）就回收了,
      //maximumPoolSize 无限大的线程池空间
      executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
          new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp Dispatcher", false));
    }
    return executorService;
  }

  public synchronized void setMaxRequests(int maxRequests) {
    if (maxRequests < 1) {
      throw new IllegalArgumentException("max < 1: " + maxRequests);
    }
    this.maxRequests = maxRequests;
    promoteCalls();
  }

  public synchronized int getMaxRequests() {
    return maxRequests;
  }

  public synchronized void setMaxRequestsPerHost(int maxRequestsPerHost) {
    if (maxRequestsPerHost < 1) {
      throw new IllegalArgumentException("max < 1: " + maxRequestsPerHost);
    }
    this.maxRequestsPerHost = maxRequestsPerHost;
    promoteCalls();
  }

  public synchronized int getMaxRequestsPerHost() {
    return maxRequestsPerHost;
  }

  synchronized void enqueue(AsyncCall call) {
    if (runningCalls.size() < maxRequests && runningCallsForHost(call) < maxRequestsPerHost) {
      runningCalls.add(call);
      getExecutorService().execute(call);
    } else {
      readyCalls.add(call);
    }
  }

  //取消带有tag的所有请求
  public synchronized void cancel(Object tag) {
    for (AsyncCall call : readyCalls) {
      if (Util.equal(tag, call.tag())) {
        call.cancel();
      }
    }

    for (AsyncCall call : runningCalls) {
      if (Util.equal(tag, call.tag())) {
        call.get().canceled = true;
        HttpEngine engine = call.get().engine;
        if (engine != null) engine.cancel();
      }
    }

    for (Call call : executedCalls) {
      if (Util.equal(tag, call.tag())) {
        call.cancel();
      }
    }
  }

  //异步请求结束
  //当该异步请求结束的时候，会调用此方法，
  //用于将运行中的异步请求队列中的该请求移除并调整请求队列
  //此时就绪队列中的请求就可以进入运行中的队列
  synchronized void finished(AsyncCall call) {
    if (!runningCalls.remove(call)) throw new AssertionError("AsyncCall wasn't running!");
    promoteCalls();
  }

  //根据maxRequests和maxRequestsPerHost来调整
  //runningAsyncCalls和readyAsyncCalls
  //使运行中的异步请求不超过两种最大值
  //并且如果队列有空闲，将就绪状态的请求归类为运行中。
  private void promoteCalls() {
    //运行中的异步请求队列的请求数大于最大请求数，那么就没必要去将就绪状态的请求移动到运行中。
    //其实就是说，如果有超过最大请求数的请求正在运行，是不需要将其移出队列的，继续运行完即可
    if (runningCalls.size() >= maxRequests) return;
    //如果就绪的队列为空，那就更没有必要移动了，因为都没有。
    if (readyCalls.isEmpty()) return; 
    //遍历就绪队列
    for (Iterator<AsyncCall> i = readyCalls.iterator(); i.hasNext(); ) {
      //取出一个请求
      AsyncCall call = i.next();
      //如果当前请求对应的host下，没有超过maxRequestsPerHost
      //那么将其从就绪队列中移除，并加入在运行队列。
      if (runningCallsForHost(call) < maxRequestsPerHost) { 
        //移除        
        i.remove();
        //加入运行队列
        runningCalls.add(call);
        //立即执行该请求
        getExecutorService().execute(call);
      }
        //如果运行队列已经到达了最大请求数上限
        //此时如果还有就绪中的请求，也不管了
      if (runningCalls.size() >= maxRequests) return; 
    }
  }

  //对比已有的运行中的请求和当前请求的host
  private int runningCallsForHost(AsyncCall call) {
    int result = 0;
    for (AsyncCall c : runningCalls) {
      if (c.host().equals(call.host())) result++;
    }
    return result;
  }

  synchronized void executed(Call call) {
    executedCalls.add(call);
  }

  //同步请求结束
  //当该同步请求结束的时候，会调用此方法，
  //用于将运行中的同步请求队列中的该请求移除
  synchronized void finished(Call call) {
    if (!executedCalls.remove(call)) throw new AssertionError("Call wasn't in-flight!");
  }

  public synchronized int getRunningCallCount() {
    return runningCalls.size();
  }

  public synchronized int getQueuedCallCount() {
    return readyCalls.size();
  }
}


