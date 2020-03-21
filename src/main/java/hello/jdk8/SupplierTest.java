package hello.jdk8;

import java.util.function.Supplier;

/**
 * @Description TODO
 * @Date 2020/3/21 15:23
 * @Created karl xie
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier=()->"hello";
        System.out.println(supplier.get());
    }
}
