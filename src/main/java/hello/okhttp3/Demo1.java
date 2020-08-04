package hello.okhttp3;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 *
 * @Override
 * public Response execute() throws IOException {
 *      // 方法检测，execute只能调用1次
 *     synchronized (this) {
 *       if (executed) throw new IllegalStateException("Already Executed");
 *       executed = true;
 *     }
 *     try {
 *        // 将RealCall添加到Dispatcher中的同步请求队列中
 *       client.dispatcher().executed(this);
 *        // 获取响应的数据
 *        // Okhttp会对数据（请求流和响应流）进行拦截进行一些额外的处理，
 *        // 比如失败重连，添加请求头，没网络优先返回缓存数据等等。
 *        // 这一拦截过程，采用责任链模式来实现的，和Android中的事件传递机制差不多
 *       Response result = getResponseWithInterceptorChain();
 *       if (result == null) throw new IOException("Canceled");
 *       return result;
 *     } finally {
 *        // 请求完成或者取消，都会将RealCall从同步请求队列中移除
 *       client.dispatcher().finished(this);
 *     }
 * }
 * 同步请求
 * @author karl xie
 * Created on 2020-08-05 03:47
 */
@Slf4j
public class Demo1 {

    private static final String URL="https://www.baidu.com/";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(URL).build();
        Response response = client.newCall(request).execute();
    }
}