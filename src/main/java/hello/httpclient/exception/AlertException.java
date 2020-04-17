package hello.httpclient.exception;

import java.io.IOException;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
public class AlertException extends RuntimeException {
    public AlertException(IOException cause) {
        super(cause);
    }
}
