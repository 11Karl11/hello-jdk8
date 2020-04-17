package hello.httpclient.api;

import hello.httpclient.model.AlertMessage;
import hello.httpclient.model.AlertResult;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
public interface HttpAlertClient {

    AlertResult sendMessage(AlertMessage alertMessage);
}
