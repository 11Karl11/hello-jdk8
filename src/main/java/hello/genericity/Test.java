package hello.genericity;

/**
 * 泛型的实质就是一个类型的占位符
 *
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        // Person<String> person1 = new Person<>();
        // Person person2 = new Person();

        // Person3<String> person3 = new Person3<>();
        // person3.show("1");
        //
        // Person3 person31 = new Person3();
        // person31.show("1hello");
        //
        // Person3.show1("111");
        //
        // System.out.println(Person3.show2("add"));
        PerIntImpl perInt = new PerIntImpl();
        perInt.show("name");

        PerIntImpl2 perIntImpl2 = new PerIntImpl2();
        perIntImpl2.show(1);

        PerIntImpl3<String> stringPerIntImpl3 = new PerIntImpl3<>();
        stringPerIntImpl3.show("name");

        PerIntImpl3 perIntImpl3 = new PerIntImpl3();
        perIntImpl3.show(1111);


    }
}