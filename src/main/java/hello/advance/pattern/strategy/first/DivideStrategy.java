package hello.advance.pattern.strategy.first;

/**
 * @author karl xie
 */
public class DivideStrategy implements Strategy {
    @Override
    public double calculate(double a, double b) {
        if (b == 0)
            throw new ArithmeticException();
        return a / b;
    }
}