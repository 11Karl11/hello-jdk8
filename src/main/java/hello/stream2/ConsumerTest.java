package hello.stream2;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @Description TODO
 * @Date 2020/4/5 15:24
 * @Created karl xie
 */
public class ConsumerTest {
    public static void main(String[] args) {

        ConsumerTest consumerTest = new ConsumerTest();
        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = i -> System.out.println(i);
        System.out.println(consumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        consumerTest.test(consumer);//面向对象方式
        //consumerTest.test((Consumer<Integer>) intConsumer);
        consumerTest.test(consumer::accept);//函数式方式
        consumerTest.test(intConsumer::accept);//函数式方式
        consumerTest.test(i-> System.out.println(i));
    }

    public void test(Consumer<Integer> consumer) {
        consumer.accept(100);
    }
}
