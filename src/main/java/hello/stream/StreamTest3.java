package hello.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/3/21 22:29
 * @Created karl xie
 */
public class StreamTest3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        System.out.println(list.stream().map(i -> 2 * i)
                .reduce(0, Integer::sum));

    }
}
