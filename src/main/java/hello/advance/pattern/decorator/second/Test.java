package hello.advance.pattern.decorator.second;

import hello.utils.CodeUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author karl xie
 * Created on 2021-01-05 21:58
 */
public class Test {

    /***
     * 模拟真实工作情况 - service层接口定义完毕，现有ServiceImpl及CleanImpl两个service
     * 在不修改service代码的情况下，为serviceImpl增加clean的功能
     *
     * 即以ServiceImpl为核心，为其装饰CleanImpl功能, 增强handle的功能
     *
     */
    public static void main(String[] args){
        Map<String, Object> map = new HashMap<>();
        map.put("key", "Somethings...");

        String eventId = UUID.randomUUID().toString();

        Service service = new ServiceImpl();
        service.handleEvent(eventId, map);

        CodeUtils.spilt();

        service = new CleanImplDecorator(service);
        service.handleEvent(eventId, map);
    }
}