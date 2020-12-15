package hello.advance.pattern.strategy.first;

/**
 * @author karl xie
 * Created on 2020-12-14 19:23
 */
public class DivideStrategy implements Strategy {
    @Override
    public double calculate(double a, double b) {
        if (b == 0)
            throw new ArithmeticException();
        return a / b;
    }
}