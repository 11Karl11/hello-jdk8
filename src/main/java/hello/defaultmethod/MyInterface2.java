package hello.defaultmethod;

/**
 * @Description TODO
 * @Date 2020/3/21 21:49
 * @Created karl xie
 */
public interface MyInterface2 {
    default void myMethod(){
        System.out.println("myInterface2");
    }

}
