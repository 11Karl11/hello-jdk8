package hello.advance.pattern.decorator.first;

/**
 * @author karl xie
 * Created on 2021-01-05 21:56
 */
public class SugarDecorator implements Component{

    Component coffee;

    SugarDecorator(Component coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getName() {
        return coffee.getName() + ", 糖";
    }

    @Override
    public double getSpend() {
        return coffee.getSpend() + 0.5D;
    }
}