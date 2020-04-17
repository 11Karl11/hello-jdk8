package hello.stream;

import java.util.stream.IntStream;

/**
 * @Description TODO
 * @Date 2020/3/22 10:39
 * @Created karl xie
 */
public class StreamTest8 {
    public static void main(String[] args) {
        IntStream.iterate(0,i->(i+1)%2)
                .limit(6)
                .distinct()
                .forEach(System.out::println);
    }
}
