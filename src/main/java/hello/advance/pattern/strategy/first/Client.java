package hello.advance.pattern.strategy.first;

/**
 * @author karl xie
 */
public class Client { 

    public static void main(String[] args) {
        new Context(new SumStrategy()).result(20, 10);
        new Context(new MinusStrategy()).result(20, 10);
        new Context(new MultiplyStrategy()).result(20, 10);
        new Context(new DivideStrategy()).result(20, 10);
    }
}