package hello.concurrent.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Future的缺点：
 *
 * 无法方便得知任务何时完成
 * 无法方便获得任务结果
 * 在主线程获得任务结果会导致主线程阻塞
 * @author karl xie
 */
public class FutureTest {


    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        java.util.concurrent.Future<String> future = executor.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello world";
        });

        System.out.println("异步结果："+future.get());
    }
}