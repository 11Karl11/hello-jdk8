package hello.advance.pattern.builder.second;

/**
 * @author karl xie
 * Created on 2021-01-05 20:20
 */
public interface Builder {

    void buildPartOne();

    void buildPartTwo();

    void buildPartThr();

    /***
     * 一般情况肯定是一个复杂的对象
     */
    String getResult();
}