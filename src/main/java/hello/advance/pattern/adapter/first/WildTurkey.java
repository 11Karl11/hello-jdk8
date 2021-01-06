package hello.advance.pattern.adapter.first;

/**
 * @author karl xie
 * Created on 2021-01-05 22:16
 */
public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("咯咯");
    }

    @Override
    public void fly() {
        System.out.println("我在飞，虽然我飞的很近");
    }
}