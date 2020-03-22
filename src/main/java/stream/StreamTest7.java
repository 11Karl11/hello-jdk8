package stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/22 10:34
 * @Created karl xie
 */
public class StreamTest7 {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("hello", "world", "hello world");
//        list.stream().map(item->item.substring(0,1)
//                .toUpperCase()+item.substring(1))
//                .forEach(i-> System.out.println(i));
        list.stream().map(item->{
            String s = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return s;
        }).forEach(System.out::println);

    }
}
