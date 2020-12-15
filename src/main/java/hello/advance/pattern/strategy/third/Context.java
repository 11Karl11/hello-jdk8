package hello.advance.pattern.strategy.third;

/**
 * @author karl xie
 * Created on 2020-12-14 19:48
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