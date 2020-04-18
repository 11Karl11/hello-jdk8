package hello.concurrent.thread2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 其实CountDownLatch类的原理挺简单的，内部同样是⼀个基层了AQS的实现类
 * Sync，且实现起来还很简单，可能是JDK⾥⾯AQS的⼦类中最简单的实现了，有兴 趣的读者可以去看看这个内部类的源码。
 * 需要注意的是构造器中的计数值（count）实际上就是闭锁需要等待的线程数量。 这个值只能被设置⼀次，⽽且CountDownLatch没有提供任何机制去重新设置这个 计数值。
 * @author karl xie
 * Created on 2020-04-18 14:28
 */
public class CountDownLatchDemo {
    // 定义前置任务线程
    static class PreTaskThread implements Runnable {
        private String task;
        private CountDownLatch countDownLatch;

        public PreTaskThread(String task, CountDownLatch countDownLatch) {
            this.task = task;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
                System.out.println(task + " - 任务完成");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 假设有三个模块需要加载
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // 主任务
        new Thread(() -> {
            try {
                System.out.println("等待数据加载...");
                System.out.println(String.format("还有%d个前置任务", countDownLatch.getCount()));
                countDownLatch.await();
                System.out.println("数据加载完成，正式开始游戏！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 前置任务
        new Thread(new PreTaskThread("加载地图数据", countDownLatch)).start();
        new Thread(new PreTaskThread("加载⼈物模型", countDownLatch)).start();
        new Thread(new PreTaskThread("加载背景⾳乐", countDownLatch)).start();
    }
}