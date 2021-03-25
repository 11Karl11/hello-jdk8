package hello.concurrent.async;

import java.util.concurrent.CompletableFuture;

/**
 * thenCompose相当于flatMap,避免CompletableFuture<CompletableFuture<String>>这种写法。
 * @author karl xie
 */
public class CompletableFutureTest2 {

    public static void main(String[] args) throws Exception{
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() ->
                "hello"
        );
        // f2虽然依赖f1的结果，但不会等待f1结果返回，而是再包装成一个future返回
        CompletableFuture<String> f2 = f1.thenComposeAsync(t ->
                CompletableFuture.supplyAsync(() ->
                        t + " world"
                )
        );
        // 等到真正调用的时候再执行f2里的逻辑
        System.out.println("异步结果:" + f2.get());

    }
}