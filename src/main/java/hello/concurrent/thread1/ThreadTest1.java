package hello.concurrent.thread1;

/**
 * @author karl xie
 * Created on 2020-04-14 19:08
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            try {
                thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我执行了");
        });
        t1.start();
        try {
            t1.join(2000);//主线程等待2秒后才会执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程");
    }

}