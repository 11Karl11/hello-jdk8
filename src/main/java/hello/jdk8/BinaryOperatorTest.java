package hello.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @Description TODO
 * @Date 2020/3/21 15:34
 * @Created karl xie
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest test = new BinaryOperatorTest();
        System.out.println(test.operator(1,2,(a,b)->a+b));
        System.out.println(test.operator(1,2,(a,b)->a-b));

        System.out.println("----------------");
        System.out.println(test.getShort("hello123","world",
                (a,b)->a.length()-b.length()));
        System.out.println(test.getShort("hello","world",
                (a,b)->a.charAt(0)-b.charAt(0)));
    }

    public int operator(int a, int b,
                        BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

    public String getShort(String a, String b, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(a,b);

    }
}
