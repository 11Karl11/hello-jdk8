package hello.advance.pattern.decorator.second;

import java.util.Map;

/**
 * @author karl xie
 * Created on 2021-01-05 21:57
 */
public interface Service {

    void handleEvent(String eventId, Map<String, Object> map);
}
