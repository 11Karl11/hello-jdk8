package hello.advance.pattern.state.third;

/**
 * @author karl xie
 */
public class HighState extends AbstractState{

    public HighState(AbstractState state){
        super("high", state.getScore());
    }

    @Override
    protected void addScore0(int n, ScoreContext context) {
        if(n < 60){
            context.setState(new LowState(this));
        }else if (n < 90){
            context.setState(new MiddleState(this));
        }
    }

}