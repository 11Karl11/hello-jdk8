package hello.httpclient.core;



import hello.httpclient.model.HttpResult;

import java.io.IOException;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
public interface HttpClient {
    /**
     * Get
     * @param path /a/b
     * @return
     */
    HttpResult httpGet(String path) throws IOException;

    HttpResult httpGet(String path, Object paramValues) throws IOException;

    HttpResult httpDelete(String path) throws IOException;

    HttpResult httpPost(String path, Object paramValues, Object body) throws IOException;
}
