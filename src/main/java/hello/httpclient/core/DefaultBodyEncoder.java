package hello.httpclient.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author karl xie
 * Created on 2020-04-17 13:57
 */
public class DefaultBodyEncoder implements BodyEncoder {

    private ObjectMapper objectMapper;

    public DefaultBodyEncoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public DefaultBodyEncoder() {
        this(new ObjectMapper());
    }

    public byte[] encode(Object body) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(body);
    }
}
