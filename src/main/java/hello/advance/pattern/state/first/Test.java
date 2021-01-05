package hello.advance.pattern.state.first;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        context.giveMoney();
        context.move();
        context.grab();

        context.grab();
        context.move();
        context.giveMoney();
    }
}