package hello.advance.others.anonymous;

/**
 *  匿名内部类与局部类对作用域内的变量拥有相同的的访问权限。
 *
 * (1)、匿名内部类可以访问外部类的所有成员；
 *
 * (2)、匿名内部类不能访问外部类未加final修饰的变量（注意：JDK1.8即使没有用final修饰也可以访问）；
 *
 * (3)、属性屏蔽，与内嵌类相同，匿名内部类定义的类型（如变量）会屏蔽其作用域范围内的其他同名类型（变量）：
 *
 * 这个实例中有三个变量x：1、ShadowTest类的成员变量；2、内部类FirstLevel的成员变量；3、内部类方法methodInFirstLevel的参数。
 *
 * methodInFirstLevel的参数x屏蔽了内部类FirstLevel的成员变量，因此，在该方法内部使用x时实际上是使用的是参数x，可以使用this关键字来指定引用是成员变量x：
 *
 *  1 System.out.println("this.x = " + this.x);
 *
 * 利用类名来引用其成员变量拥有最高的优先级，不会被其他同名变量屏蔽，如：
 *
 *  1 System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
 * @author karl xie
 */
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}