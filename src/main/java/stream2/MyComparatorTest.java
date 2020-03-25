package stream2;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description TODO
 * @Date 2020/3/25 22:15
 * @Created karl xie
 */
public class MyComparatorTest {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("nihao", "hello", "world", "welcome");
//        Collections.sort(list);
//        System.out.println(list);
//        list.sort((o1,o2)->o1.length()-o2.length());
//        System.out.println(list);
//
//        list.sort((o1,o2)->o2.length()-o1.length());
//        System.out.println(list);

        //Collections.sort(list, Comparator.comparingInt(String::length).reversed());
//        Collections.sort(list,
//                Comparator.comparingInt((String item)->item.length()).reversed());
//        list.sort(Comparator.comparingInt(String::length).reversed());
//        list.sort(Comparator.comparingInt((String item)->
//                item.length()).reversed());
//         list.sort(Comparator.comparingInt(String::length).
//                 thenComparing(String.CASE_INSENSITIVE_ORDER));
//        Collections.sort(list,
//                Comparator.comparingInt(String::length)
//        .thenComparing((o1,o2)->o1.toLowerCase().compareTo(o2.toLowerCase())));
//        Collections.sort(list,
//                Comparator.comparingInt(String::length)
//        .thenComparing(Comparator.comparing(String::toLowerCase)));
//
//        Collections.sort(list,
//                Comparator.comparingInt(String::length)
//        .thenComparing(Comparator.comparing(
//                String::toLowerCase,Comparator.reverseOrder()
//        )));
//        Collections.sort(list,
//                Comparator.comparingInt(String::length)
//        .reversed()
//        .thenComparing(Comparator.comparing(String::toLowerCase,
//                Comparator.reverseOrder())));
        Collections.sort(list,
                Comparator.comparingInt(String::length).reversed().
                thenComparing(Comparator.comparing(String::toLowerCase,
                        Comparator.reverseOrder()))
        .thenComparing(Comparator.reverseOrder()));


        System.out.println(list);


    }
}
