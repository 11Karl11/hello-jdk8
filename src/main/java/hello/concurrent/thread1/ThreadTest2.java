package hello.concurrent.thread1;

/**
 * @author karl xie
 * Created on 2020-04-15 18:59
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });
        System.out.println(thread.getState());
    }
}