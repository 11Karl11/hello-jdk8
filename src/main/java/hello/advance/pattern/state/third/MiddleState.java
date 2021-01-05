package hello.advance.pattern.state.third;

/**
 * @author karl xie
 */
public class MiddleState extends AbstractState{

    public MiddleState(AbstractState state) {
        super("middle", state.getScore());
    }

    @Override
    protected void addScore0(int n, ScoreContext context) {
        if(n >= 90){
            context.setState(new HighState(this));
        }else if(n < 60){
            context.setState(new LowState(this));
        }
    }

}