package hello.assertdemo;

/**
 *
 * -ea java -ea 打开所有用户类的assertion
 * -da java -da 关闭所有用户类的assertion
 * -ea:<classname> java -ea:MyClass1 打开MyClass1的assertion
 * -da:<classname> java -da: MyClass1 关闭MyClass1的assertion
 * -ea:<packagename> java -ea:pkg1 打开pkg1包的assertion
 * -da:<packagename> java -da:pkg1 关闭pkg1包的assertion
 * -ea:... java -ea:... 打开缺省包(无名包)的assertion
 * -da:... java -da:... 关闭缺省包(无名包)的assertion
 * -ea:<packagename>... java -ea:pkg1... 打开pkg1包和其子包的assertion
 * -da:<packagename>... java -da:pkg1... 关闭pkg1包和其子包的assertion
 * -esa java -esa 打开系统类的assertion
 * -dsa java -dsa 关闭系统类的assertion
 * 综合使用 java -dsa:MyClass1:pkg1 关闭MyClass1和pkg1包的assertion
 * @author karl xie
 * Created on 2020-05-19 14:11
 */
public class AssertTest2 {

    public static void main(String[] args) {
        //useAssertExt1();

        useAssertExt2();

    }

    /**
     * 断言的使用方法一
     */
    public static void useAssertExt1() {
        boolean isOk = 1 > 2;
        assert isOk;
        System.out.println("程序正常");
    }


    /**
     * 断言的第一个例子
     * assert后面跟个冒号表达式。如果冒烟前为true，则冒号后面的被忽略，否则抛出AssertionError,错误内容为冒号后面的内容。
     *
     * 　　按F3查看源代码，如下，可以看到AssertionError是继承自Error，而不是Exception，所以catch部分用Exception是不能捕捉到AssertionError信息的。
     */
    public static void useAssertExt2() {
        boolean isOk = 1 > 2;
        try {
            assert isOk : "程序错误";
            System.out.println("程序正常");
        } catch (AssertionError err) {
            System.out.println(err.getMessage());
        }
    }
}