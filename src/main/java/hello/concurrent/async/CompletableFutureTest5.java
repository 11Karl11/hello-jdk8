package hello.concurrent.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * allOf方法是当所有的CompletableFuture都执行完后执行计算，无返回值。
 * @author karl xie
 */
public class CompletableFutureTest5 {

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
            return "world";
        });
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "karl demo";
        });
        List<CompletableFuture<String>> list = new ArrayList<>();
        list.add(f1);
        list.add(f2);
        list.add(f3);

        CompletableFuture<Void> f4 = CompletableFuture.allOf(list.toArray(new CompletableFuture[]{}));
        long time = System.currentTimeMillis();
        f4.thenRun(() ->
                list.forEach(f -> {
                    try {
                        System.out.println("异步结果:" + f.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
        );
        f4.get();
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }
}