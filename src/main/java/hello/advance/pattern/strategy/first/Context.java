package hello.advance.pattern.strategy.first;

/**
 * 负责和具体的策略类交互
 *
 * @author karl xie
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void result(double a, double b) {
        System.out.println("计算结果： " + strategy.calculate(a, b));
    }
}