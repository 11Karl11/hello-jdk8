package methodreference;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description TODO
 * @Date 2020/3/21 17:38
 * @Created karl xie
 */
public class MethodReferenceTest {
    public String  getString(Supplier<String> supplier){
        return supplier.get()+"test";

    }
public String getString2(String str, Function<String ,String> function){
        return function.apply(str);
}
    public static void main(String[] args) {
        Student zhangsan = new Student("zhangsan", 80);
        Student lisi = new Student("lisi", 3);
        Student wangwu = new Student("wangwu", 300);
        Student zhaoliu = new Student("zhaoliu", 6);
        ArrayList<Student> students = Lists.newArrayList(zhangsan, lisi, wangwu, zhaoliu);
//        students.sort((student1,student2)->
//                Student.compareStudentBySocre(student1,student2));
//        students.forEach(item-> System.out.println(item.getScore()));
//        System.out.println("------------");
//        students.sort(Student::compareStudentBySocre);
//        students.forEach(student -> System.out.println(student.getScore()));
//        System.out.println("-----");
//        students.sort(Student::compareStudentByName);
//        students.forEach(item-> System.out.println(item.getName()));
//        StudentComparator studentComparator = new StudentComparator();
////        students.sort((param1,param2)->studentComparator.compareStudentBySore(param1,param2));
////        students.forEach(item-> System.out.println(item.getScore()));
////        students.sort(studentComparator::compareStudentBySore);
////        students.forEach(item-> System.out.println(item.getScore()));
//        students.sort(studentComparator::compareStudentByName);
//        students.forEach(item-> System.out.println(item.getName()));
//        students.sort(Student::compareByScore);
//        students.forEach(item-> System.out.println(item.getScore()));
//        students.sort(Student::compareByName);
//        students.forEach(item -> System.out.println(item.getName()));
//        ArrayList<String> cities =
//                Lists.newArrayList("qingdao", "chongqing", "tianjin", "beijing");
////        Collections.sort(cities,
////                (city1,city2)->city1.compareToIgnoreCase(city2));
////        cities.forEach(item-> System.out.println(item));
//
//        Collections.sort(cities,String::compareToIgnoreCase);
//        cities.forEach(System.out::println);
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("hello",String::new));
    }
}
