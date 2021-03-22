package hello.genericity.other2;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符？意义就是它是一个未知的符号，可以是代表任意的类。
 * 无边界通配符 ？ 能取不能存。这个好理解，因为编译器不知道?具体是啥类型，故不能存；但是任意类型都继承于Object，故能取，但取出默认为Object对象。
 * @author karl xie
 */
public class Test1 {

    public static void main(String[] args) {

        // ArrayList<A> list = new ArrayList<B>();
        List<?> list;
        list = new ArrayList<A>();
        list = new ArrayList<B>();
        list = new ArrayList<C>();
        list = new ArrayList<D>();
        Object o = list.get(0); //编译通过
        // list.add(new A());      //编译不通过
        // list.add(new B());      //编译不通过
        // list.add(new C());      //编译不通过
        // list.add(new D());      //编译不通过

    }
}