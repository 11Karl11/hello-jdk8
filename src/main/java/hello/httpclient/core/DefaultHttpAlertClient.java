package hello.httpclient.core;

import hello.httpclient.api.HttpAlertClient;
import hello.httpclient.exception.AlertException;
import hello.httpclient.model.AlertMessage;
import hello.httpclient.model.AlertResult;
import hello.httpclient.model.HttpResult;

import java.io.IOException;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
public class DefaultHttpAlertClient implements HttpAlertClient {

    private HttpClient httpClient;
    private String     webHookUrl;

    public DefaultHttpAlertClient(HttpClient httpClient, String webHookUrl) {
        this.httpClient = httpClient;
        this.webHookUrl = webHookUrl;
    }

    public AlertResult sendMessage(AlertMessage alertMessage) {
        try {
            HttpResult result = httpClient.httpPost(webHookUrl, null, alertMessage);
            if (result.isSuccess()) {
                return null;
            }
            return null;
        } catch (IOException e) {
            throw new AlertException(e);
        }
    }
}
