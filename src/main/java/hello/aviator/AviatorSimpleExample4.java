package hello.aviator;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author karl xie
 */
public class AviatorSimpleExample4 {

    public static void main(String[] args) {
        AviatorEvaluator.addFunction(new MinFunction());
        String expression = "rangeClosed(a,b,dataPoint)";
        Expression compiledExp = AviatorEvaluator.compile(expression, true);
        Map<String, Object> env = new HashMap<>();
        env.put("a", 1);
        env.put("b", 45);
        env.put("dataPoint", 50);
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);

        Range<Integer> range = Range.range(2, BoundType.OPEN, 4, BoundType.OPEN);
        System.out.println(range.contains(3));
    }

    static class MinFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            Number value = FunctionUtils.getNumberValue(arg3, env);
            Range<Double> closed = Range.closed(left.doubleValue(), right.doubleValue());
            return AviatorBoolean.valueOf(closed.contains(value.doubleValue()));
        }

        public String getName() {
            return "rangeClosed";
        }
    }
}