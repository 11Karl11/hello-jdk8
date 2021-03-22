package hello.genericity.other2;

import java.util.ArrayList;
import java.util.List;

/**
 * 上边界符 ? extends 只是限定了赋值给它的实例类型(这里为赋值给listC的实例类型)，且边界包括自身。
 * 上边界符 ? extends 跟 ？ 一样能取不能存，道理是一样的，虽然限定了上边界，但编译器依然不知道 ? 是啥类型，故不能存；但是限定了上边界，故取出来的对象类型默认为上边界的类型
 *
 * @author karl xie
 */
public class Test2 {

    public static void main(String[] args) {
        List<? extends C> listC = new ArrayList<>();
        // listC = new ArrayList<A>(); //编译不通过
        // listC = new ArrayList<B>(); //编译不通过
        listC = new ArrayList<C>(); //编译通过
        listC = new ArrayList<D>(); //编译通过

        C c = listC.get(0); //编译通过
        // listC.add(new C()); //编译不通过
        // listC.add(new D()); //编译不通过

    }
}