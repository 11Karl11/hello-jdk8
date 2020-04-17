package hello.httpclient.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import hello.httpclient.model.HttpResult;
import okhttp3.Call;
import okhttp3.*;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
public class DefaultHttpClient implements HttpClient {
    private OkHttpClient okHttpClient;
    private BodyEncoder  bodyEncoder;

    public DefaultHttpClient(OkHttpClient okHttpClient, BodyEncoder bodyEncoder) {
        this.okHttpClient = okHttpClient;
        this.bodyEncoder = bodyEncoder;
    }

    public DefaultHttpClient() {
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public void setBodyEncoder(BodyEncoder bodyEncoder) {
        this.bodyEncoder = bodyEncoder;
    }

    public HttpResult httpGet(String path) throws IOException {
        return httpGet(path, null);
    }

    public HttpResult httpGet(String path, Object paramValues) throws IOException {
        Call call = okHttpClient.newCall(new Builder().get().url(path).build());
        Response response = call.execute();
        return toHttpResult(response);
    }

    public HttpResult httpDelete(String path) throws IOException {
        Call call = okHttpClient.newCall(new Builder().delete().url(path).build());
        Response response = call.execute();
        return toHttpResult(response);
    }

    public HttpResult httpPost(String path, Object paramValues, Object body) throws IOException {
        Call call = okHttpClient.newCall(new Builder().post(RequestBody.create(MediaType.parse("application/json"), toStringBody(body)))
                .url(path).build());
        Response response = call.execute();
        return toHttpResult(response);
    }

    private byte[] toStringBody(Object body) throws JsonProcessingException {
        return bodyEncoder.encode(body);
    }

    private HttpResult toHttpResult(Response response) throws IOException {
        return new HttpResult(response.code(), response.body().string(), response.headers().toMultimap());
    }
}
