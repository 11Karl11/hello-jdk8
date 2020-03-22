package stream2;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.*;

/**
 * @Description TODO
 * @Date 2020/3/22 21:12
 * @Created karl xie
 */
public class StreamTest1 {
    public static void main(String[] args) {
        Student zhangsan = new Student("zhangsan", 83);
        Student lisi = new Student("lisi", 90);
        Student wangwu = new Student("wangwu", 100);
        Student zhaoliu = new Student("zhaoliu", 90);
        ArrayList<Student> students = Lists.newArrayList(zhangsan, lisi, wangwu, zhaoliu);
        List<Student> students1 = students.stream().collect(toList());
        students1.forEach(System.out::println);
        System.out.println("--------------");
        System.out.println(students.stream().collect(counting()));
        System.out.println(students.stream().count());
    }
}
