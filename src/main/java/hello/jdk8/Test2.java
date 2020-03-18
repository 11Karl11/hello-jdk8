package hello.jdk8;

/**
 * @Description TODO
 * @Date 2020/3/15 15:10
 * @Created karl xie
 */
@FunctionalInterface
interface MyInterface{
    void test();
    String toString();
}
public class Test2 {
    public void myTest(MyInterface myInterface){
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
//        test2.myTest(new MyInterface() {
//            @Override
//            public void test() {
//                System.out.println("myTest");
//            }
//        });
        test2.myTest(()->{
            System.out.println("myTest");
        });
        System.out.println("===================");
        MyInterface myInterface=()->{
            System.out.println("hello");
        };
        myInterface.test();
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);

    }


}
