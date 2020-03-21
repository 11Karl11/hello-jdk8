package hello.jdk8;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/21 17:09
 * @Created karl xie
 */
public class MetodReferenceDemo {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("hello", "world", "reference");
        //list.forEach(item-> System.out.println(item));
        list.forEach(System.out::println);

    }
}
