package defaultmethod;

/**
 * @Description TODO
 * @Date 2020/3/21 21:47
 * @Created karl xie
 */
public interface MyInterface1 {
    default void myMethod(){
        System.out.println("myInterface1");
    }
}
