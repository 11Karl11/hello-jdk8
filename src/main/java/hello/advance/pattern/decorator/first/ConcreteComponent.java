package hello.advance.pattern.decorator.first;

/**
 * @author karl xie
 * Created on 2021-01-05 21:54
 */
public class ConcreteComponent implements Component{

    private String name;

    public ConcreteComponent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSpend() {
        return 10;
    }
}