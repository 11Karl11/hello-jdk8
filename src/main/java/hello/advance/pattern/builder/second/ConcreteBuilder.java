package hello.advance.pattern.builder.second;

/**
 * @author karl xie
 * Created on 2021-01-05 20:20
 */
public class ConcreteBuilder implements Builder{

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void buildPartOne() {
        buffer.append("i am part one\n");
    }

    @Override
    public void buildPartTwo() {
        buffer.append("i am part two\n");
    }

    @Override
    public void buildPartThr() {
        buffer.append("i am part Thr\n");
    }

    @Override
    public String getResult() {
        return buffer.toString();
    }
}