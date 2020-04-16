package concurrent.thread1;

/**
 * @author karl xie
 * Created on 2020-04-15 19:14
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Thread a = new Thread(() -> testMothod(), "a");
        Thread b = new Thread(() -> testMothod(), "b");
        a.start();
        b.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getName()+":"+a.getState());
        System.out.println(b.getName()+":"+b.getState());

    }

    private static synchronized void testMothod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}