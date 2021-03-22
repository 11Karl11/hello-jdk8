package hello.genericity;

/**
 * @author karl xie
 */
public class Person3<T> {

    public void show(T name) {
        System.out.println("name: " + name);
    }
    //实例方法也可以自定义泛型
    public <M> void show4(M name) {
        System.out.println("name: " + name);
    }

    //静态方法中的类型占位符和类中的泛型占位符是没有关系的
    public static <W> void show1(W name) {
        System.out.println("show1 name: " + name);
    }

    public static <E> E show2(E name) {
        return name;
    }
}