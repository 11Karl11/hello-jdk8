package hello.concurrent.thread2;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore内部有⼀个继承了AQS的同步器Sync，重写了 tryAcquireShared ⽅ 法。在这个⽅法⾥，会去尝试获取资源。
 * 如果获取失败（想要的资源数量⼩于⽬前已有的资源数量），就会返回⼀个负数 （代表尝试获取资源失败）。然后当前线程就会进⼊AQS的等待队列。
 * @author karl xie
 * Created on 2020-04-18 13:23
 */
@Slf4j
public class SemaphoreDemo {

    static class MyThread implements Runnable {

        private int value;

        private Semaphore semaphore;

        public MyThread(int value, Semaphore semaphore) {
            this.value = value;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获取permit
                log.info("当前线程是{},还剩{}个资源,还有{}个线程在等待",
                        value, semaphore.availablePermits(), semaphore.getQueueLength());
                //登录随机,打乱释放顺序
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
                semaphore.release();//释放permit
                log.info("线程{}释放了资源",value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 可以看到，在这次运⾏中，最开始是1, 0, 6这三个线程获得了资源，⽽其它线程进 ⼊了等待队列。然后当某个线程释放资源后，
     * 就会有等待队列中的线程获得资源。 当然，Semaphore默认的acquire⽅法是会让线程进⼊等待队列，且会抛出中断异 常。但它还有⼀些⽅法可以忽略中断或不进⼊阻塞队列：
     * // 忽略中断
     * public void acquireUninterruptibly()
     * public void acquireUninterruptibly(int permits)
     * // 不进⼊等待队列，底层使⽤CAS
     * public boolean tryAcquire
     * public boolean tryAcquire(int permits)
     * public boolean tryAcquire(int permits, long timeout, TimeUnit unit)
     *  throws InterruptedException
     * public boolean tryAcquire(long timeout, TimeUnit unit)
    */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i=0;i<10;i++){
            new Thread(new MyThread(i,semaphore)).start();
        }
    }
}