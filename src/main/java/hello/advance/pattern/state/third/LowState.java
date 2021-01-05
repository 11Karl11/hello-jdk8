package hello.advance.pattern.state.third;

/**
 * @author karl xie
 */
public class LowState extends AbstractState{
    public LowState(AbstractState state) {
        super("low", state.getScore());
    }

    public LowState(String stateName, int score) {
        super(stateName, score);
    }

    @Override
    protected void addScore0(int n, ScoreContext context) {
        if(n >= 90){
            //向优秀状态转换，以下其它的状态转换同理。
            context.setState(new HighState(this));
        }else if(n >=60){
            context.setState(new MiddleState(this));
        }
    }

}