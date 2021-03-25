package hello.concurrent.async;

import java.util.concurrent.CompletableFuture;

/**
 * @author karl xie
 */
public class CompletableFutureTest3 {

    public static void main(String[] args) throws Exception{
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return " world";
        });
        CompletableFuture<String> f3 = f1.thenCombineAsync(f2, (t1, t2) ->
                t1 + t2
        );
        long time = System.currentTimeMillis();
        System.out.println("异步结果:" + f3.get());
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }
}