package hello.advance.pattern.state.third;

/**
 * @author karl xie
 */
public class ScoreContext {

    private AbstractState state;

    public ScoreContext() {
        state = new LowState("low", 0);
    }

    public void addScore(int n) {
        //具体的状态转换工作转发给各个状态类自己完成
        state.addScore(n, this);
        System.out.println("current: stateName-->" + state.getStateName() + ",score-->" + state.getScore());
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }
}