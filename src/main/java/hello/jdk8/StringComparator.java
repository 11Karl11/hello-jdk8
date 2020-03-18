package hello.jdk8;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @Date 2020/3/18 22:24
 * @Created karl xie
 */
public class StringComparator {
    public static void main(String[] args) {
        List<String> names =
                Lists.newArrayList("zhangsan", "lisi", "wangwu");
//        Collections.sort(
//                names, new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        return o2.compareTo(o1);
//                    }
//                }
//        );
//        System.out.println(names);
        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
        System.out.println(names);
    }
}
