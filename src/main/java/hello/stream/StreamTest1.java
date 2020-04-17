package hello.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Date 2020/3/21 22:22
 * @Created karl xie
 */
public class StreamTest1 {
    public static void main(String[] args) {
        //1
        Stream stream=Stream.of("hello","world","helloworld");
        String[] myArray=new String[]{"hello","1"};
        //2
        Stream<String> stream1 = Stream.of(myArray);
        Stream<String> stream2 = Arrays.stream(myArray);

        List<String> list = Arrays.asList(myArray);
        //3
        Stream<String> stream3 = list.stream();
    }
}
