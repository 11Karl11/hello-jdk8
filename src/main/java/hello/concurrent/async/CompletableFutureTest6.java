package hello.concurrent.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * anyOf方法当任意一个CompletableFuture执行完后就会执行计算。
 *
 *
 * CompletableFuture默认使用的线程池是forkJoinPool，当时对一台使用了CompletableFuture实现异步回调功能的接口做压测，
 * 通过监控系统发现有大量的ForkJoinPool.commonPool-worker-* 线程处于等待状态，进一步分析dump信息发现是forkJoinPool的makeCommonPool问题
 * 如果在项目里没有设置java.util.concurrent.ForkJoinPool.common.parallelism的值，那么forkJoinPool线程池的线程数就是(cpu-1)，
 * 我们测试环境的机器是2核，这样实际执行任务的线程数只有1个，当有大量请求过来时，如果有耗时高的io操作，势必会造成更多的线程等待，进而拖累服务响应时间。
 *
 * 解决方案一个是设置java.util.concurrent.ForkJoinPool.common.parallelism这个值(要在项目启动时指定)，或者指定线程池不使用默认的forkJoinPool。
 * @author karl xie
 */
public class CompletableFutureTest6 {

    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception{
        Random rand = new Random(); // 随机数
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
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000)); // 模拟接口调用耗时1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "karl demo";
        });

        CompletableFuture<Object> f4 = CompletableFuture.anyOf(f1, f2, f3);
        long time = System.currentTimeMillis();
        System.out.println("异步结果:" + f4.get());
        System.out.println("耗时:" + (System.currentTimeMillis() - time));
    }
}