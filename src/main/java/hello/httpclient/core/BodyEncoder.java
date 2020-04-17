package hello.httpclient.core;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
public interface BodyEncoder {
    byte[] encode(Object body) throws JsonProcessingException;
}
