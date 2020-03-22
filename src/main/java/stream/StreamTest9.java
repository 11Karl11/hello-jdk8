package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Date 2020/3/22 11:29
 * @Created karl xie
 */
public class StreamTest9 {
    public static void main(String[] args) {
//        Stream<String> limit = Stream.iterate(UUID.randomUUID().toString(), i -> UUID.randomUUID().toString()).limit(5);
//        limit.forEach(item-> System.out.println(item));
        List<String> list=new ArrayList<>(5000000);
        System.out.println(list.size());
        for (int i=0;i<5000000;++i){
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("start");

        long start = System.nanoTime();

        list.parallelStream().sorted().count();
        long end = System.nanoTime();
        long time = TimeUnit.NANOSECONDS.toMillis(end - start);
        System.out.println(time);
    }
}
