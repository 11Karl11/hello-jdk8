package hello.genericity.other;

import hello.demo.A;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        //通过使用通配符在泛型中将java中的继承关系重新绑定
        // Plate<Fruit> p = new Plate<Apple>();
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
    }
}