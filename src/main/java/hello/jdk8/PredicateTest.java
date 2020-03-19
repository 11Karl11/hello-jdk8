package hello.jdk8;

import java.util.function.Predicate;

/**
 * @Description TODO
 * @Date 2020/3/19 23:07
 * @Created karl xie
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate=
                p->p.length()>5;

        System.out.println(predicate .test("hello world"));
    }
}
