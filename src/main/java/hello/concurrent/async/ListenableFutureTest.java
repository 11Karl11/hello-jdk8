package hello.concurrent.async;

import com.google.common.util.concurrent.*;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author karl xie
 */
public class ListenableFutureTest {

    public static void main(String[] args) {

        // 创建一个由invoke线程执行的线程池
        ListeningExecutorService executorService = MoreExecutors.newDirectExecutorService();
        // 装饰自定义的线程池返回
        // ListeningExecutorService executorService1 = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        ListenableFuture<?> listenableFuture = executorService.submit(new MyCallable(3, 10));

        //ListenableFuture接口扩展自Future接口，并添加了一个新方法 addListener，该方法是给异步任务添加监听
        listenableFuture.addListener(() -> {
            try {
                System.out.println("异步结果:" + listenableFuture.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, executorService);

        // FutureCallback接口包含onSuccess()、onFailure()两个方法
        Futures.addCallback(listenableFuture, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object result) {
                System.out.println("res: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        }, executorService);


        System.out.println("----------------------------");


        ListenableFuture<Integer> future1 = executorService.submit(() -> 1 + 2);
        ListenableFuture<Integer> future2 = executorService.submit(() -> Integer.parseInt("3q"));
        ListenableFuture<List<Object>> futures = Futures.allAsList(future1, future2);
        futures = Futures.successfulAsList(future1, future2);

        Futures.addCallback(futures, new FutureCallback<List<Object>>() {
            @Override
            public void onSuccess(@Nullable List<Object> result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        }, executorService);


        System.out.println("---------------------");


        // 原Future
        ListenableFuture<String> future3 = executorService.submit(() -> "hello, future");
        // 同步转换
        ListenableFuture<Integer> future5 = Futures.transform(future3, String::length, executorService);
        Futures.addCallback(future5, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object result) {
                System.out.println("res: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        }, executorService);

        System.out.println("-----------------------------");



        // 异步转换
        ListenableFuture<Integer> future6 = Futures.transformAsync(future3, input -> Futures.immediateFuture(input.length()), executorService);


        Futures.addCallback(future6, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object result) {
                System.out.println("res: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        }, executorService);
    }
}