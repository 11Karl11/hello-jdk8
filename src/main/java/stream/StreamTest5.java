package stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Date 2020/3/22 0:07
 * @Created karl xie
 */
public class StreamTest5 {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("hello", "world", "hello world");
//        list.stream().map(item -> item.toUpperCase())
//                .collect(Collectors.toList()).forEach(System.out::println);

        list.stream().map(item -> item.toUpperCase())
                .forEach(System.out::println);
        System.out.println("----------------");
        ArrayList<Integer> list1 = Lists.newArrayList(1, 2, 3, 4);
        list1.stream().map(item->item*item).forEach(System.out::println);
        System.out.println("----------------------");
        Stream<ArrayList<Integer>> stream = Stream.of(Lists.newArrayList(1)
                , Lists.newArrayList(2)
                , Lists.newArrayList(3, 4, 5));
//        stream.flatMap(theList->theList.stream().map(item->item*item)).
//                forEach(System.out::println);
        System.out.println("-------------");
        stream.flatMap(theList->theList.stream()).map(item->item*item).
                forEach(System.out::println);
    }
}
