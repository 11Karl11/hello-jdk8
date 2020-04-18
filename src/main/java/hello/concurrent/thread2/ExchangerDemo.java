package hello.concurrent.thread2;

import java.util.concurrent.Exchanger;

/**
 * @author karl xie
 * Created on 2020-04-18 14:25
 */
public class ExchangerDemo {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                System.out.println("这是线程A，得到了另⼀个线程的数据："
                        + exchanger.exchange("这是来⾃线程A的数据"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("这个时候线程A是阻塞的，在等待线程B的数据");
        Thread.sleep(1000);
        new Thread(() -> {
            try {
                System.out.println("这是线程B，得到了另⼀个线程的数据："
                        + exchanger.exchange("这是来⾃线程B的数据"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}