package hello.demo;

import java.util.HashMap;

/**
 * @author karl xie
 * Created on 2020-04-21 11:29
 */
public class Main {

    public static <T> void out(T t) {
        System.out.println(t);
    }

    public static <T> void out(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        A<String, String> stringStringA = new A<>();
        HashMap<String, String> stringStringHashMap = new HashMap<>(1);
        out("findingsea");
        out(123);
        out(11.11);
        out(true);

        out("findingsea", 123, 11.11, true);
    }

}