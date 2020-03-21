package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Date 2020/3/21 23:14
 * @Created karl xie
 */
public class StreamTest4 {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("hello", "world", "hello world");
//       // String[] strings = stream.toArray(length -> new String[length]);
//        String[] strings = stream.toArray(String[]::new);
//        Arrays.asList(strings).forEach(System.out::println);
//        Stream<String> stream = Stream.of("hello", "world");
//        List<String> list = stream.collect(Collectors.toList());
//        list.forEach(System.out::println);
//        ArrayList list = stream.collect(() -> new ArrayList(),
//                (theList, item) -> theList.add(item),
////                (theList1, theList2) -> theList1.addAll(theList2));
//        LinkedList<String> list = stream.collect(LinkedList::new,
//                LinkedList::add,
//                LinkedList::addAll);
//        list.forEach(System.out::println);

//        Stream<String> stream = Stream.of("hello", "world", "hello world");
//        ArrayList<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        list.forEach(System.out::println);
//        TreeSet<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
//        set.forEach(System.out::println);

        Stream<String> stream = Stream.of("hello", "world", "hello world");
        String s = stream.collect(Collectors.joining());
        System.out.println(s);
    }
}
