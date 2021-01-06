package hello.advance.pattern.factory.bean;

/**
 * @author karl xie
 * Created on 2021-01-06 18:59
 */
public class AMDCpu extends AbstractCPU{

    @Override
    public void show() {
        System.out.println("This is AMD Cpu.");
    }

    @Override
    public void prepare() {
        System.out.println("This is AMD Cpu Prepare.");
    }

    @Override
    public void box() {
        System.out.println("This is AMD Cpu Box.");
    }
}