package hello.concurrent.async.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author karl xie
 */
public class Test1 {

    public static void main(String[] args) throws Exception{
        //异步操作 可以用一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //执行FutureTask，相当于上例中的 client.request("name") 发送请求
        //在这里开启线程进行RealData的call()执行
        Future<String> future = executor.submit(new RealData1("task1: "));
        System.out.println("请求完毕，数据准备中");
        //如果此时call()方法没有执行完成，则依然会等待
        System.out.println("数据 = " + future.get());

    }
}