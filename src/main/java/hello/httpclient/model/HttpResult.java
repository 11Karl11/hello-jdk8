package hello.httpclient.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
@Data
public class HttpResult {
    final public  int                       code;
    final public  String                    content;
    final private Map<String, List<String>> respHeaders;
    final private boolean                   success;

    public HttpResult(int code, String content, Map<String, List<String>> respHeaders) {
        this.code = code;
        success = code >= 200 && code < 300;

        this.content = content;
        this.respHeaders = respHeaders;
    }

    public List<String> getHeader(String name) {
        return respHeaders.get(name);
    }

    public boolean isSuccess() {
        return success;
    }
}