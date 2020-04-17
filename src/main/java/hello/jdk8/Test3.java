package hello.jdk8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;

/**
 * @Description TODO
 * @Date 2020/3/18 21:26
 * @Created karl xie
 */
public class Test3 {

    public static void main(String[] args) {
        TheInterface i1 = () -> {
        };
//        System.out.println(i1.getClass().getInterfaces()[0]);
//        TheInterface2 i2=()->{};
//        System.out.println(i2.getClass().getInterfaces()[0]);
//        new Thread(()->{
//            System.out.println("hello world");
//        }).start();
        List<String> list = Lists.newArrayList("hello", "world", "hi");
//        list.forEach((item)->{
//            System.out.println(item.toUpperCase());
//        });
        List<String> list2 = Lists.newArrayList();
//        list.forEach((item)->list2.add(item.toUpperCase()));
//        list2.forEach(item-> System.out.println(item));
//        list.hello.stream().map(item -> item.toUpperCase())
//                  .forEach(item-> System.out.println(item));
//        list.hello.stream().map(String::toUpperCase).forEach(item-> System.out.println(item));
//        Function<String ,String> function=String::toUpperCase;
//        System.out.println(function.getClass().getInterfaces()[0]);

    }
}

@FunctionalInterface
interface TheInterface {
    void myMthod();
}

@FunctionalInterface
interface TheInterface2 {
    void myMethod2();
}
