package stream;

import java.util.stream.IntStream;

/**
 * @Description TODO
 * @Date 2020/3/21 22:26
 * @Created karl xie
 */
public class StreamTest2 {
    public static void main(String[] args) {
        IntStream.of(new int[]{1,2,3}).forEach(i-> System.out.println(i));
        System.out.println("---------------");
        IntStream.range(3,8).forEach(System.out::println);
        System.out.println("----------------");
        IntStream.rangeClosed(3,8).forEach(System.out::println);
    }
}
