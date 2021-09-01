package hello.advance.demo;

/**
 * @author karl xie
 * Created on 2021-07-07 20:35
 */
public class Client {

    public static void main(String[] args) {
        Student.test(new Object());
        System.out.println(Student.a);
        F.createCpu("INTEL").show();
    }
}