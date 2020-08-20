package hello.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Date 2020/3/22 20:20
 * @Created karl xie
 */
public class StreamTest13 {
    public static void main(String[] args) {
        Student zhangsan1 = new Student("zhangsan", 100, 20);
        Student lisi = new Student("lisi", 90, 20);
        Student wangwu = new Student("wangwu", 80, 30);
        Student zhansan2 = new Student("zhangsan", 70, 40);
        ArrayList<Student> students = Lists.newArrayList(zhangsan1, lisi, wangwu, zhansan2);
//        Map<String, List<Student>> map = students.hello.stream().collect(
//                Collectors.groupingBy(student -> student.getName()));
//        Map<Integer, List<Student>> map = students.hello.stream().collect(Collectors.groupingBy(Student::getScore));
//        Map<String, Long> map = students.hello.stream().collect(Collectors.groupingBy(Student::getName,
//                Collectors.counting()));
//        Map<String, Double> map = students.hello.stream().collect(Collectors.groupingBy(
//                Student::getName, Collectors.averagingDouble(
//                        Student::getScore
//                )
//        ));
        //分区,只有两组true/false
        // Map<Boolean, List<Student>> map = students.stream().collect(Collectors.partitioningBy(
        //         student -> student.getScore() >= 90
        // ));

        //Duplicate key  key值一样会报错
        // Map<Integer, Student> map = students.stream().collect(Collectors.toMap(Student::getAge, r -> r));

        Map<Integer, Student> map = students.stream().collect(Collectors.toMap(Student::getAge, r -> r,(r1,r2)->r1));
        System.out.println(map);

    }
}
