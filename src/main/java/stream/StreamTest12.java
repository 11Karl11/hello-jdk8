package stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Date 2020/3/22 20:09
 * @Created karl xie
 */
public class StreamTest12 {
    public static void main(String[] args) {
        ArrayList<String> list1 = Lists.newArrayList("Hi", "Hello", "你好");
        ArrayList<String> list2 = Lists.newArrayList("zhangsan", "lisi", "wangwu", "zhaoliu");
        List<String> strings = list1.stream().flatMap(item -> list2.stream().map(
                item2 -> item + " " + item2
        )).collect(Collectors.toList());
        strings.forEach(System.out::println);
    }
}
