package hello.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * @author karl xie
 */
public class AviatorSimpleExample2 {

    public static void main(String[] args) {
        String expression = "a-(b-c)>100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", 199.100);
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);

        System.out.println("-------------------------------------");

        String expression1 = "a<=c && a>=b";
        Expression compile1 = AviatorEvaluator.compile(expression1);
        Boolean result1 = (Boolean) compile1.execute(env);
        System.out.println(result1);
    }
}