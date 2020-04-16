package concurrent.thread1;

/**
 * @author karl xie
 * Created on 2020-04-15 19:52
 */
public class ThreadTest5 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> testMothod(), "a");
        Thread b = new Thread(() -> testMothod(), "b");
        a.start();
        /**
         * 调⽤join()⽅法不会释放锁，会⼀直等待当前线程执⾏完毕（转换为
         * TERMINATED状态）。
         */
        a.join(1000);//等待a线程执行完毕
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