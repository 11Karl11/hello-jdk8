package hello.advance.others.anonymous;

/**
 * 匿名内部类中不能定义静态属性、方法；　　
 * 匿名内部类可以有常量属性（final修饰的属性）；
 *
 * (6)、匿名内部内中可以定义属性，如上面代码中的代码:private int x = 1;
 *
 * (7)、匿名内部内中可以可以有额外的方法（父接口、类中没有的方法）;
 *
 * (8)、匿名内部内中可以定义内部类；
 *
 * (9)、匿名内部内中可以对其他类进行实例化。
 * @author karl xie
 */
public class ShadowTest1 {
    public int x = 0;

    interface FirstLevel {
        void methodInFirstLevel(int x);
    }

    FirstLevel firstLevel =  new FirstLevel() {

        @Override
        public void methodInFirstLevel(int x) {

        }

        public int x = 1;

        //public static String str = "Hello World";   // 编译报错

        // public static void aa() {        // 编译报错
        // }

        public static final String finalStr = "Hello World";  // 正常

        public void extraMethod() {  // 正常
            // do something
        }
    };
}