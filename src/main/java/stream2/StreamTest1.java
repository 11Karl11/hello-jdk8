package stream2;

import com.google.common.collect.Lists;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @Description TODO
 * @Date 2020/3/22 21:12
 * @Created karl xie
 */
public class StreamTest1 {
    public static void main(String[] args) {
        Student zhangsan = new Student("zhangsan", 80);
        Student lisi = new Student("lisi", 90);
        Student wangwu = new Student("wangwu", 100);
        Student zhaoliu = new Student("zhaoliu", 90);
        Student zhaoliu1 = new Student("zhaoliu", 90);
        ArrayList<Student> students = Lists.newArrayList(
                zhangsan, lisi, wangwu, zhaoliu, zhaoliu1);
//        List<Student> students1 = students.stream().collect(toList());
//        students1.forEach(System.out::println);
//        System.out.println("--------------");
//        System.out.println(students.stream().collect(counting()));
//        System.out.println(students.stream().count());
//        students.stream().collect(
//                minBy(Comparator.comparingInt(Student::getScore)))
//                .ifPresent(System.out::println);
//        students.stream().collect(
//                maxBy(Comparator.comparingInt(Student::getScore))
//        ).ifPresent(System.out::println);
//        System.out.println(students.stream().collect(
//                averagingInt(Student::getScore)
//        ));
//        System.out.println(students.stream().collect(
//                summingInt(Student::getScore)
//        ));
//        System.out.println(students.stream().collect(
//                summarizingInt(Student::getScore)
//        ));
//
//        System.out.println(students.stream().map(Student::getName)
//                .collect(joining()));
//        System.out.println(students.stream().map(Student::getName)
//                .collect(joining(",")));
//        System.out.println(students.stream().map(Student::getName)
//                .collect(joining(",","begin","end")));
        Map<Integer, Map<String, List<Student>>> collect = students.stream().collect(
                groupingBy(Student::getScore, groupingBy(Student::getName))
        );
        System.out.println(collect);

        System.out.println(students.stream().collect(
                partitioningBy(student -> student.getScore() > 80)
        ));
        Map<Boolean, Map<Boolean, List<Student>>> collect1 = students.stream().collect(
                partitioningBy(student -> student.getScore() > 80,
                        partitioningBy(student -> student.getScore() > 90))
        );
        System.out.println(collect1);

        System.out.println(students.stream().collect(
                partitioningBy(student -> student.getScore() > 80, counting())
        ));

        Map<String, Student> collect2 = students.stream().collect(
                groupingBy(Student::getName,
                        collectingAndThen(
                                minBy(Comparator.comparingInt(Student::getScore)),
                                Optional::get)
                )
        );
        System.out.println(collect2);
        for (Student student : students) {
            students.get(0);
        }
    }
}
