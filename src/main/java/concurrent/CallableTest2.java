package concurrent;

import java.util.concurrent.*;

/**
 * 使⽤上与第⼀个Demo有⼀点⼩的区别。
 * ⾸先，调⽤ submit ⽅法是没有返回值的。 这⾥实际上是调⽤的 submit(Runnable task) ⽅法，⽽上⾯的Demo，调⽤的 是 submit(Callable<T> task) ⽅法。
 * 然后，这⾥是使⽤ FutureTask 直接取 get 取值，⽽上⾯的Demo是通过 submit ⽅ 法返回的 Future 去取值。 在很多⾼并发的环境下，有可能Callable和FutureTask会创建多次。
 * FutureTask能 够在⾼并发环境下确保任务只执⾏⼀次。这块有兴趣的同学可以参看FutureTask源码
 * @author karl xie
 * Created on 2020-04-14 19:29
 */
public class CallableTest2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> task = new FutureTask<>(new CallableTest2());
        executorService.submit(task);
        System.out.println(task.get());
        executorService.shutdown();

    }
}