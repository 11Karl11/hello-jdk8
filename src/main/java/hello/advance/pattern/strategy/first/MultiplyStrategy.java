package hello.advance.pattern.strategy.first;

/**
 * @author karl xie
 * Created on 2020-12-14 19:22
 */
public class MultiplyStrategy implements Strategy {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}