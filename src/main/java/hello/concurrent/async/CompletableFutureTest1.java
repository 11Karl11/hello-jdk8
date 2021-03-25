package hello.concurrent.async;

import java.util.concurrent.CompletableFuture;

/**
 * 但CompletableFuture处理简单的任务可以使用，但并不是一个完整的反应式编程解决方案，
 * 在服务调用复杂的情况下，存在服务编排、上下文传递、柔性限流(背压)方面的不足
 * @author karl xie
 */
public class CompletableFutureTest1 {

    public static void main(String[] args) throws Exception{
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() ->
                "hello"
        );
        // f2依赖f1的结果做转换
        CompletableFuture<String> f2 = f1.thenApplyAsync(t ->
                t + " world"
        );
        System.out.println("异步结果:" + f2.get());

    }
}