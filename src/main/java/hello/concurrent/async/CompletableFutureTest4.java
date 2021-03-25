package hello.concurrent.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * 输出的结果有时候是hello 有时候是world，哪个future先执行完就根据它的结果计算，取两个future最先返回的。
 *
 * 这里要说明一点，如果两个future是同时返回结果，那么applyToEitherAsync永远以第一个future的结果为准，大家可以把上面代码的Thread.sleep注释掉测试下。
 * @author karl xie
 */
public class CompletableFutureTest4 {

    public static void main(String[] args) throws Exception{
        Random rand = new Random();
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000)); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000)); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world";
        });
        CompletableFuture<String> f3 = f1.applyToEitherAsync(f2, t -> t);
        long time = System.currentTimeMillis();
        System.out.println("异步结果:" + f3.get());
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }
}