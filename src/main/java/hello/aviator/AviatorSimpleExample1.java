package hello.aviator;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author karl xie
 */
public class AviatorSimpleExample1 {
    public static void main(String[] args) {
        String name = "JACK";
        Map<String,Object> env = new HashMap<>();
        env.put("name", name);
        String result = (String) AviatorEvaluator.execute(" 'Hello ' + name ", env);
        System.out.println(result);

        System.out.println("--------------------------------");

        String str = "使用Aviator";
        Map<String,Object> obj = new HashMap<>();
        obj.put("str",str);
        Long length = (Long)AviatorEvaluator.execute("string.length(str)",obj);
        System.out.println(length);
    }
}