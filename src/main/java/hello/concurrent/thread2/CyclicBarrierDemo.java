package hello.concurrent.thread2;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 注意这⾥跟CountDownLatch的代码有⼀些不同。CyclicBarrier没有分 为 await() 和 countDown() ，⽽是只有单独的⼀个 await() ⽅法。
 * ⼀旦调⽤await()⽅法的线程数量等于构造⽅法中传⼊的任务总量（这⾥是3），就 代表达到屏障了。
 * CyclicBarrier允许我们在达到屏障的时候可以执⾏⼀个任务，可 以在构造⽅法传⼊⼀个Runnable类型的对象。上述案例就是在达到屏障时，输出 “本关卡所有前置任务完成，开始游戏...”。
 * 构造⽅法
 * public CyclicBarrier(int parties) {
 * this(parties, null);
 * }
 * public CyclicBarrier(int parties, Runnable barrierAction) {
 * 具体实现 }
 * <p>
 * CyclicBarrier虽说功能与CountDownLatch类似，但是实现原理却完全不同，
 * CyclicBarrier内部使⽤的是Lock + Condition实现的等待/通知模式。详情可以查看 这个⽅法的源码：
 * private int dowait(boolean timed, long nanos)
 *
 * @author karl xie
 * Created on 2020-04-18 14:39
 */
public class CyclicBarrierDemo {

    static class PreTaskThread implements Runnable {
        private String task;
        private CyclicBarrier cyclicBarrier;

        public PreTaskThread(String task, CyclicBarrier cyclicBarrier) {
            this.task = task;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            // 假设总共三个关卡
            for (int i = 1; i < 4; i++) {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(String.format("关卡%d的任务%s完成", i, task));
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                cyclicBarrier.reset(); // 重置屏障
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
            System.out.println("本关卡所有前置任务完成，开始游戏...");
        });
        new Thread(new PreTaskThread("加载地图数据", cyclicBarrier)).start();
        new Thread(new PreTaskThread("加载⼈物模型", cyclicBarrier)).start();
        new Thread(new PreTaskThread("加载背景⾳乐", cyclicBarrier)).start();
    }
}