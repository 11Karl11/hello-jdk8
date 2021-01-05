package hello.advance.pattern.builder.second;

/**
 * @author karl xie
 * Created on 2021-01-05 20:21
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartOne();
        builder.buildPartTwo();
        builder.buildPartThr();
    }
}