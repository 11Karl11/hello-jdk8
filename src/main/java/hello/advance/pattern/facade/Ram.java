package hello.advance.pattern.facade;

/**
 * @author karl xie
 */
public class Ram implements Computer {

    @Override
    public void open() {
        System.out.println("Ram Open.");
    }
}