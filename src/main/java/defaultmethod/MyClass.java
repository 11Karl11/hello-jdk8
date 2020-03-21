package defaultmethod;

/**
 * @Description TODO
 * @Date 2020/3/21 21:48
 * @Created karl xie
 */
public class MyClass extends MyInterface1Impl implements MyInterface2 {
//    @Override
//    public void myMethod() {
//        MyInterface2.super.myMethod();
//    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
