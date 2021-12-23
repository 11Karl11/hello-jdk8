package hello.demo;

/**
 * @author karl xie
 */
public class Base implements Cloneable{

    @Override protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // ①
    }
}