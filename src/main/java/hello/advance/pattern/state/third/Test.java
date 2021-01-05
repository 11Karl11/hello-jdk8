package hello.advance.pattern.state.third;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        ScoreContext context = new ScoreContext();
        context.addScore(10);
        context.addScore(50);
        context.addScore(-10);
        context.addScore(45);
        context.addScore(-60);
    }

}