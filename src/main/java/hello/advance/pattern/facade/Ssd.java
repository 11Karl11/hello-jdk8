package hello.advance.pattern.facade;

/**
 * @author karl xie
 */
public class Ssd implements Computer {

    @Override
    public void open() {
        System.out.println("SSD Open.");
    }
}