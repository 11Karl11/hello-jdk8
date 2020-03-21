package stream;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Date 2020/3/22 0:21
 * @Created karl xie
 */
public class StreamTest6 {
    public static void main(String[] args) {
        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);
        generate.findFirst().ifPresent(System.out::println);
        Stream<Integer> iterate = Stream.iterate(1, item -> item + 2)
                .limit(5);
        iterate.forEach(System.out::println);

        Stream<Integer> limit = Stream.iterate(1, item -> item + 2).limit(6);
        System.out.println(limit.filter(item->item>2)
        .mapToInt(item->2*item)
        .skip(2)
        .limit(2)
        .sum());
    }
}
