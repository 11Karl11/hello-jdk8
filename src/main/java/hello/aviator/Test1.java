package hello.aviator;

import com.googlecode.aviator.AviatorEvaluator;

/**
 * Aviator是一个高性能、轻量级的java语言实现的表达式求值引擎，主要用于各种表达式的动态求值。
 * https://www.cnblogs.com/kaleidoscope/p/13132315.html
 * @author karl xie
 */
public class Test1 {

    public static void main(String[] args) {
        Long result = (Long)AviatorEvaluator.execute("1+2+3");
        System.out.println(result);
    }
}