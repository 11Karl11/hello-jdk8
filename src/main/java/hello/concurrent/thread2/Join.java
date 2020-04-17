package hello.concurrent.thread2;

/**
 * 注意join()⽅法有两个重载⽅法，⼀个是join(long)， ⼀个是join(long, int)。 实际上，通过源码你会发现，join()⽅法及其重载⽅法底层都是利⽤了
 * wait(long)这个⽅法。 对于join(long, int)，通过查看源码(JDK 1.8)发现，底层并没有精确到纳秒， ⽽是对第⼆个参数做了简单的判断和处理。
 *
 *
 * sleep⽅法是Thread类的⼀个静态⽅法。它的作⽤是让当前线程睡眠⼀段时间。它 有这样两个⽅法：
 * Thread.sleep(long)
 * Thread.sleep(long, int)
 * 同样，查看源码(JDK 1.8)发现，第⼆个⽅法貌似只对第⼆个参数做了简单的 处理，没有精确到纳秒。实际上还是调⽤的第⼀个⽅法。
 * 这⾥需要强调⼀下：sleep⽅法是不会释放当前的锁的，⽽wait⽅法会。这也是最
 * 常⻅的⼀个多线程⾯试题。 它们还有这些区别：
 * wait可以指定时间，也可以不指定；⽽sleep必须指定时间。
 * wait释放cpu资源，同时释放锁；sleep释放cpu资源，但是不释放锁，所以易 死锁。
 * wait必须放在同步块或同步⽅法中，⽽sleep可以再任意位置
 * @author karl xie
 * Created on 2020-04-15 20:55
 */
public class Join {
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("我是⼦线程，我先睡⼀秒");
                Thread.sleep(1000);
                System.out.println("我是⼦线程，我睡完了⼀秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        thread.join();
        System.out.println("如果不加join⽅法，我会先被打出来，加了就不⼀样了");
    }
}