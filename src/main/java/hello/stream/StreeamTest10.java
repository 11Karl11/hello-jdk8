package hello.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/22 11:40
 * @Created karl xie
 */
public class StreeamTest10 {
    public static void main(String[] args) {
        ArrayList<String> list =
                Lists.newArrayList("hello1", "world1", "hello world");
//        list.hello.stream().filter(item->item.length()==5).limit(1)
//                .forEach(System.out::println);
//        list.hello.stream().mapToInt(item->item.length())
//                .filter(length->length==5)
//                .findFirst()
//                .ifPresent(System.out::println);
        list.stream().mapToInt(item->{
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(i->i==5)
                .findFirst()//findFirst短路计算
                .ifPresent(System.out::println);

    }
}
