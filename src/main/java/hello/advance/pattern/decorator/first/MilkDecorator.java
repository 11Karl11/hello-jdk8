package hello.advance.pattern.decorator.first;

/**
 * @author karl xie
 * Created on 2021-01-05 21:54
 */
public class MilkDecorator implements Component{

    Component coffee;

    MilkDecorator(Component coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getName() {
        return coffee.getName() + ", 牛奶";
    }

    @Override
    public double getSpend() {
        return coffee.getSpend() + 2D;
    }
}