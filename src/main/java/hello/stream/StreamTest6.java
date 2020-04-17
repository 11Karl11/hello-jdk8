package hello.stream;

import java.util.stream.Stream;

/**
 * @Description TODO
 * @Date 2020/3/22 0:21
 * @Created karl xie
 */
public class StreamTest6 {
    public static void main(String[] args) {
//        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);
//        generate.findFirst().ifPresent(System.out::println);
//        Stream<Integer> iterate = Stream.iterate(1, item -> item + 2)
//                .limit(5);
//        iterate.forEach(System.out::println);

        Stream<Integer> limit = Stream.iterate(1, item -> item + 2).limit(6);
//        System.out.println(limit.filter(item->item>2)
//        .mapToInt(item->2*item)
//        .skip(2)
//        .limit(2)
//        .sum());
//        limit.filter(item->item>200)
//                .mapToInt(item->2*item)
//                .skip(2)
//                .limit(2)
//                .max()
//                .ifPresent(System.out::println);

//        IntSummaryStatistics intSummaryStatistics = limit.filter(item -> item > 2)
//                .mapToInt(item -> 2 * item)
//                .skip(2)
//                .limit(2)
//                .summaryStatistics();
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println(intSummaryStatistics.getMin());
//        System.out.println(intSummaryStatistics.getAverage());
//        System.out.println(limit);
//        System.out.println(limit.filter(item->item>2));
//        System.out.println(limit.distinct());
        System.out.println(limit);
        Stream<Integer> stream = limit.filter(i -> i > 2);
        System.out.println(stream);
        Stream<Integer> stream1 = stream.distinct();
        System.out.println(stream1);
    }
}
