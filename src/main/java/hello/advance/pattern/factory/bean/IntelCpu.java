package hello.advance.pattern.factory.bean;

/**
 * @author karl xie
 * Created on 2021-01-06 19:00
 */
public class IntelCpu extends AbstractCPU{

    @Override
    public void show() {
        System.out.println("This is Intel Cpu.");
    }

    @Override
    public void prepare() {
        System.out.println("This is Intel Cpu Prepare.");
    }

    @Override
    public void box() {
        System.out.println("This is Intel Cpu Box.");
    }

}