package hello.jdk8;

import java.util.function.Supplier;

/**
 * @Description TODO
 * @Date 2020/3/21 15:25
 * @Created karl xie
 */
public class StudenTest {
    public static void main(String[] args) {
        Supplier<Student> supplier=()->new Student();
        System.out.println(supplier.get().getName());

        System.out.println("--------------------");

        Supplier<Student> supplier2=Student::new;

        System.out.println(supplier2.get().getName());


    }
}
