package hello.advance.pattern.decorator.second;

import java.util.Map;

/**
 * @author karl xie
 * Created on 2021-01-05 21:58
 */
public class CleanImplDecorator implements Service{

    Service service;

    public CleanImplDecorator (Service service) {
        this.service = service;
    }

    @Override
    public void handleEvent(String eventId, Map<String, Object> map) {
        service.handleEvent(eventId, map);
        System.out.println("************************************************");
        System.out.println("this is CleanImpl, just for clean for eventId...");
    }

}