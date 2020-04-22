package hello.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author karl xie
 * Created on 2020-04-21 16:44
 */
@Slf4j
public class MapTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","2");
        map.put("2","3");
        map.put("3","4");
        Collection<String> values = map.values();
        values.stream().forEach(System.out::println);
        map.forEach((k,v)-> log.info("key:{},value:{}",k,v));
    }
}