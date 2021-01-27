package hello.advance.pattern.strategy.first;

/**
 * @author karl xie
 */
public class MinusStrategy implements Strategy {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}