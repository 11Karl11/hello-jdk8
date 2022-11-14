package hello.concurrent.thread2;

import java.util.concurrent.Semaphore;

/**
 * @author karl xie
 * Created on 2022-11-14 16:08
 */
public class SemaphoreDemo2 {

    public static void main(String[] args) throws InterruptedException {
        //创建信号量，并且赋予2个初始值
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取资源，若此时资源被用光，则阻塞，直到有线程归还资源
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "获取资源");
                        Thread.sleep(3000);
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName() + "释放资源");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.yield();
    }
}