package concurrent.thread1;

/**
 * @author karl xie
 * Created on 2020-04-15 19:58
 */
public class ThreadTest6 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> testMothod(), "a");
        Thread b = new Thread(() -> testMothod(), "b");
        a.start();
        a.interrupt();
        b.start();
        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());

    }

    private static synchronized void testMothod() {
        try {
            System.out.println("start  name:" + Thread.currentThread().getName());
            Thread.sleep(2000L);
            System.out.println("end name:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}