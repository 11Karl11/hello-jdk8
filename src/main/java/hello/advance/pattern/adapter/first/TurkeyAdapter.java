package hello.advance.pattern.adapter.first;

/**
 * @author karl xie
 * Created on 2021-01-05 22:15
 */
public class TurkeyAdapter implements Duck{

    Turkey turkey;

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }
}