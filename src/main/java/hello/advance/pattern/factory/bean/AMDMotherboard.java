package hello.advance.pattern.factory.bean;

/**
 * @author karl xie
 * Created on 2021-01-06 19:00
 */
public class AMDMotherboard extends AbstractMotherboard{

    @Override
    public void show() {
        System.out.println("This is AMD Motherboard");
    }

    @Override
    public void prepare() {
        System.out.println("This is AMD Motherboard Prepare");
    }

    @Override
    public void box() {
        System.out.println("This is AMD Motherboard Box");
    }
}