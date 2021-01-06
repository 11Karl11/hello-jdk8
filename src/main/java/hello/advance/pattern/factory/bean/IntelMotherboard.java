package hello.advance.pattern.factory.bean;

/**
 * @author karl xie
 * Created on 2021-01-06 19:02
 */
public class IntelMotherboard extends AbstractMotherboard{

    @Override
    public void show() {
        System.out.println("This is Intel Motherboard");
    }

    @Override
    public void prepare() {
        System.out.println("This is Intel Motherboard Prepare");
    }

    @Override
    public void box() {
        System.out.println("This is Intel Motherboard Box");
    }
}