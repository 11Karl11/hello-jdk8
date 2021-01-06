package hello.advance.pattern.facade;

/**
 * @author karl xie
 */
public class Cpu implements Computer {

    @Override
    public void open() {
        System.out.println("Cpu Open.");
    }
}