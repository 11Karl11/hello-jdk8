package hello.okhttp3;

import okhttp3.*;

import java.io.IOException;

/**
 * 异步请求
 * 不管是同步请求还是异步请求，都需要初始化OkHttpClient以及创建一个Request，然后再调用OkHttpClinet的newCall方法，创建出一个RealCall对象
 * 对于同步请求，是调用RealCall的execute方法；而异步请求，则是调用RealCall的enqueue方法实现
 *
 *
 * @Override
 * public void enqueue(Callback responseCallback) {
 *     // 和execute一样，enqueue也只能调用1次
 *     synchronized (this) {
 *       if (executed) throw new IllegalStateException("Already Executed");
 *       executed = true;
 *     }
 *     // 执行请求
 *     client.dispatcher().enqueue(new AsyncCall(responseCallback));
 * }
 *
 *
 * @author karl xie
 * Created on 2020-08-05 04:01
 */
public class Demo2 {

    private static final String URL="https://www.baidu.com/";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response);
            }
        });
    }
}