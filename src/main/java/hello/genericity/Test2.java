package hello.genericity;

/**
 * 通配符: 由于java中的继承关系在泛型中不做任何声明修饰的情况下是不被认可的，所以要使用通配符进行处理；
 * 通过使用通配符在泛型中将java中的继承关系重新绑定
 *
 * 通配符一般使用？来表示，可以理解为？在泛型中所有类的父类
 *
 * 通配符的上边界(extends)，下边界(super):
 * 上边界：在读取T这个类型的数据的时候，但不写入数据的时候，使用上边界
 * 下边界：需要写入数据的时候，单不需要读取的时候
 * java中的继承，并不是泛型中的继承：java中的父子类关系，在泛型中并不是父子类关系
 * @author karl xie
 */
public class Test2 {

    public static void main(String[] args) {
        Person4<Number> p1 = new Person4<>();
        Person4<Integer> p2 = new Person4<>();
        p2.setName(111);
        //java中的继承，并不是泛型中的继承：java中的父子类关系，在泛型中并不是父子类关系
        // p1.show1(p2);

        p1.show2(p2);

        System.out.println(p1.getName());


        System.out.println("---------------------------");

        Person4<Integer> p3 = new Person4<>();
        Person4<String> p4 = new Person4<>();
        p4.setName("111");
        p3.show2(p4);
        System.out.println(p3.getName());

        System.out.println("-----------------");
        Person4<Number> p5 = new Person4<>();
        Person4<Integer> p6 = new Person4<>();
        p6.setName(111);
        p5.show3(p6);
        System.out.println(p5.getName());

        System.out.println("-------------");
        Person4<Integer> p7 = new Person4<>();
        Person4<Number> p8 = new Person4<>();
        p8.setName(111);
        p7.show4(p8);
        System.out.println(p3.getName());
    }
}