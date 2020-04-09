package stream2;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Date 2020/3/29 16:47
 * @Created karl xie
 */
public class StreamTest2 {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("hello", "world", "hello world");
        NullPointerException my_exception = new NullPointerException("my exception");
        try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aaa");
                //throw  my_exception;
                //throw  new NullPointerException("first exception");
                throw  new NullPointerException("first exception");
            }).onClose(() -> {
                System.out.println("bbb");
               // throw  new ArithmeticException("second exception");
                //throw my_exception;
                throw  new NullPointerException("second exception");
            }).forEach(i -> System.out.println(i));

        }


    }
}
