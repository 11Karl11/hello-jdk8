package hello.advance.pattern.diversification.processor.basic;


import hello.advance.pattern.diversification.processor.ProcessEvent;
import hello.advance.pattern.diversification.processor.chain.ProcessorAdapter;

import java.util.concurrent.*;

public class ExecutorProcessor<T> extends ProcessorAdapter<T> {
  private static final int BASE_THREAD_NUMBER = 0;

  private static final int DEFAULT_MAX_POOL_SIZE = 16;

  private static final long DEFAULT_KEEPALIVE_TIME = 30;

  private final Executor executor;

  public ExecutorProcessor() {
    Executor executor =
        createDefaultExecutor(
            BASE_THREAD_NUMBER,
            DEFAULT_MAX_POOL_SIZE,
            DEFAULT_KEEPALIVE_TIME,
            TimeUnit.SECONDS,
            Executors.defaultThreadFactory());
    this.executor = executor;
  }

  private Executor createDefaultExecutor(
      int corePoolSize,
      int maximumPoolSize,
      long keepAliveTime,
      TimeUnit seconds,
      ThreadFactory threadFactory) {
    return new ThreadPoolExecutor(
        corePoolSize,
        maximumPoolSize,
        keepAliveTime,
        seconds,
        new SynchronousQueue<Runnable>(),
        threadFactory,
        new ThreadPoolExecutor.CallerRunsPolicy());
  }

  @Override
  public void process(NextProcessor nextProcessor, T message) {
    ProcessEvent event = new ProcessEvent(nextProcessor, message);
    fire(event);
  }

  private void fire(ProcessEvent event) {
    executor.execute(event);
  }
}
