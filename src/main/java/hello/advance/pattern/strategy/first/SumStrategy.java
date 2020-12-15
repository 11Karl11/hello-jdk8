package hello.advance.pattern.strategy.first;

/**
 * @author karl xie
 * Created on 2020-12-14 19:21
 */
public class SumStrategy implements Strategy {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}