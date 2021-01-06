package hello.advance.pattern.decorator.first;

/**
 * @author karl xie
 * Created on 2021-01-05 21:56
 */
public class Test {
    public static void main(String[] args){
        Component coffe = new ConcreteComponent("摩卡咖啡");
        System.out.println("name : -> " + coffe.getName());
        System.out.println("spand: -> " + coffe.getSpend());

        coffe = new MilkDecorator(coffe);
        coffe = new SugarDecorator(coffe);
        System.out.println("name : -> " + coffe.getName());
        System.out.println("spand: -> " + coffe.getSpend());
    }
}