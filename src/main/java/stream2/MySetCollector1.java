package stream2;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @Description TODO
 * @Date 2020/3/26 22:22
 * @Created karl xie
 */
public class MySetCollector1<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked");
        return Set<T>::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoked");
      //  return t->t;
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("Characteristics invoked");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,UNORDERED));
    }

    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("hello", "world", "welcome");
        Set<String> collect = list.stream().collect(new MySetCollector1<>());
        System.out.println(collect);
    }
}
