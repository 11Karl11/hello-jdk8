package hello.genericity.other2;

import java.util.ArrayList;
import java.util.List;

/**
 * 下边界符 ？super，跟上边界符一样，只是限定了赋值给它的实例类型，也包括边界自身
 * 下边界符 ？super 能存能取，因为设定了下边界，故我们能存下边界以下的类型，当然也包括边界自身；然而取得时候编译器依然不知道 ? 具体是什么类型，故取出默认为Object类型。
 *
 * @author karl xie
 */
public class Test3 {

    public static void main(String[] args) {
        List<? super B> listB;
        listB = new ArrayList<A>(); //编译通过
        listB = new ArrayList<B>(); //编译通过
        // listB = new ArrayList<C>(); //编译不通过
        // listB = new ArrayList<D>(); //编译不通过

        // listB.add(new A()); //编译不通过
        listB.add(new B()); //编译通过
        listB.add(new C()); //编译通过
        listB.add(new D()); //编译通过
        Object o = listB.get(0); //编译通过
        System.out.println(o);


    }
}