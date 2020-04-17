package hello.stream2;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/29 16:57
 * @Created karl xie
 */
public class StreamTest3 {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("hello", "world", "hello world");
        list.forEach(System.out::println);
        list.stream().forEach(i-> System.out.println(i));

        System.out.println("-------------");
        list.stream().forEach(System.out::println);//流相关的内部迭代
        list.forEach(System.out::println);//和流没有关系的
    }
}
