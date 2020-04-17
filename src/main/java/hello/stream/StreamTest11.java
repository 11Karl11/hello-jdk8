package hello.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TODO
 * @Date 2020/3/22 11:49
 * @Created karl xie
 */
public class StreamTest11 {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("hello welcome", "world hello",
                "hello world hello", "hello welcome");
//        list.hello.stream().map(item->item.split(" "))
//                .distinct()
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        list.stream().map(item->item.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
        System.out.println("----------------");
        list.stream().map(item->item.split(" "))
                .flatMap(item->{
                    ArrayList<String> list1 = Lists.newArrayList(item);
                    return list1.stream();
                })
                .distinct()
                .forEach(System.out::println);

    }
}
