package hello.jdk8;

import java.util.function.Function;

/**
 * @Description TODO
 * @Date 2020/3/18 22:45
 * @Created karl xie
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
       System.out.println(functionTest.compute(1,value->{return  2*value;}));
       // System.out.println(functionTest.compute(2,value->5+value));
       // System.out.println(functionTest.compute(3,value->value*value));
       // System.out.println(functionTest.convert(3,value->String.valueOf(value+"hello")));
       //  Function<Integer,Integer> function=value->value*2;
       //  System.out.println(functionTest.compute(4,function));
    }
    public int compute(int a, Function<Integer,Integer> function){
        int result=function.apply(a);
        return result;
    }
    public int method1(int a,int b){
        return a+b;
    }

    public String convert(int a,Function<Integer,String> function){
        return function.apply(a);

    }
}
