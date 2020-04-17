package hello.stream2;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @Description TODO
 * @Date 2020/3/26 22:47
 * @Created karl xie
 */
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked");
       // return HashSet::new;
        return ()->{
            System.out.println("--------------");
            return new HashSet<>();
        };
    }

//    @Override
//    public BiConsumer<Set<T>, T> accumulator() {
//        System.out.println("accumulator invoked");
//        return (set,item)->set.add(item);
//    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked");
        return (set, item) -> {
            System.out.println(set + "(在Characteristics.CONCURRENT有可能会出现ConcurrentModificationException)accumulator by threadName:  " + Thread.currentThread().getName());
            set.add(item);
        };
    }

    //并行流下如果是Characteristics.CONCURRENT  该方法不会被调用
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked");
        return (set1, set2) -> {
            System.out.println("set1-------------------------"+set1);
            System.out.println("set2------------------------"+set2);
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked");
        return set -> {
            Map<T, T> map = new TreeMap<>();
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
        //,Characteristics.CONCURRENT));//called concurrently with the same result container from multiple
         //* threads.  多个线程执行一个结果容器
        /**
         * ConcurrentModificationException
         * it is not generally permissible for one thread to modify a Collection
         *  * while another thread is iterating over it.
         */
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1; ++i) {
            ArrayList<String> list = Lists.newArrayList("hello", "world", "hello",
                    "a", "b", "c", "d", "e", "f", "g");
            HashSet<String> set = new HashSet<>();
            set.addAll(list);
            System.out.println(set);
            Map<String, String> collect = set.stream().collect(new MySetCollector2<>());
            System.out.println(collect);
        }
    }
}
