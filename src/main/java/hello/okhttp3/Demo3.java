package hello.okhttp3;

import okhttp3.*;

import java.io.IOException;

import static sun.plugin.javascript.navig.JSType.URL;

/**
 * OkHttpCLient:在Okhttp库中，OkHttpClient处于一个中心者的地位，很多功能都需要通过它来转发或者实现的。在创建的时候，
 * 初始化了很多功能类，比如缓存，拦截器，网络连接池，分发器等类。 由于初始化比较复杂，OkHttpClient内部提供了Builder模式来创建，一般情况下，OkHttpClient是唯一的
 * Request:是用来构建一个请求对象的，符合Http请求的标准，包含了请求头，方法等等属性，较为复杂，因此同样提供Builder模式构建。
 * Response:是用来构建一个响应对象的，包含了响应头，响应码，数据等等属性，同样也提供Builder模式构建
 *
 * RealCall
 * // 同步
 * client.newCall(request).execute()
 * // 异步
 * client.newCall(request).enqueue(Callback)
 *
 * 同步和异步请求，都是调用OkHttpClient的newCall方法创建一个RealCall对象，然后通过这个对象，执行请求的
 *
 * @Override
 * public Call newCall(Request request) {
 *     return new RealCall(this, request);
 * }
 *
 *
 * @author karl xie
 * Created on 2020-08-05 04:09
 */
public class Demo3 {

}