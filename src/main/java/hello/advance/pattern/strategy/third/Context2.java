package hello.advance.pattern.strategy.third;

/**
 * 策略模式与简单工厂结合
 * @author karl xie
 * Created on 2020-12-14 19:49
 */
public class Context2 {

    Strategy strategy = null;

    public Context2(String type) {
        switch (type) {
            case "A":
                strategy = new AlgorithmA();
                break;
            case "B":
                strategy = new AlgorithmB();
                break;

        }
    }

    public void contextInterface() {
        strategy.AlgorithmInterface();
    }
}