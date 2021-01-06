package hello.advance.pattern.decorator.second;

import java.util.Map;

/**
 * @author karl xie
 * Created on 2021-01-05 21:58
 */
public class ServiceImpl implements Service{

    @Override
    public void handleEvent(String eventId, Map<String, Object> map) {
        System.out.println("eventId: -> " + eventId);
        System.out.println("map:     -> " + map);
        System.out.println("this is serviceImpl event handle.");
    }
}