package hello.advance.pattern.strategy.third;

/**
 * @author karl xie
 */
public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.AlgorithmInterface();
    }
}