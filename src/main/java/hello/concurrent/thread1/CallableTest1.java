package hello.concurrent.thread1;

import java.util.concurrent.*;

/**
 * @author karl xie
 * Created on 2020-04-14 19:19
 */
public class CallableTest1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        //模拟计算需要两秒
        Thread.sleep(2000);
        return 2;
    }

    public static void main(String[] args) throws Exception {
        CallableTest1 callableTest1 = new CallableTest1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(callableTest1);
        /*
         *注意是试图取消，并不⼀定能取消成功。因为任务可能已完成、已取消、或者⼀些 其它因素不能取消，存在取消失败的可能。
         *  boolean 类型的返回值是“是否取消成 功”的意思。参数 mayInterruptIfRunning 表示是否采⽤中断的⽅式取消线程执⾏。
         */
        boolean cancel = future.cancel(false);
        System.out.println("是否取消成功:" + cancel);

        /*
        为了让任务有能够取消的功能，就使⽤ Callable 来代替 Runnable 。 如果为了可取消性⽽使⽤ Future 但⼜不提供可⽤的结果，
        则可以声明 Future<?> 形式类型、并返回 null 作为底层任务的结果。
        */
        System.out.println(future.get());
        executorService.shutdown();

    }
}