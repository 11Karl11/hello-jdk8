package hello.advance.pattern.state.third;

/**
 * @author karl xie
 */
public abstract class AbstractState {
    private String stateName;
    private int score;

    public AbstractState(String stateName, int score) {
        this.stateName = stateName;
        this.score = score;
    }

    public void addScore(int n, ScoreContext context) {
        score += n;
        addScore0(score, context);
    }

    //各个不同状态类各自的状态转换的判断逻辑，各自实现。
    protected abstract void addScore0(int n, ScoreContext context);

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}