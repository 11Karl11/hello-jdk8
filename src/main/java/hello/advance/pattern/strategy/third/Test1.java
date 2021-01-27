package hello.advance.pattern.strategy.third;

/**
 * @author karl xie
 */
public class Test1 {

    public static void main(String[] args) {
        Context context = null;
        context = new Context(new AlgorithmA());
        context.contextInterface();

        context = new Context(new AlgorithmB());
        context.contextInterface();

    }
}