package hello.advance.pattern.state.first;

/**
 * @author karl xie
 */
public class Context {

    // 起始状态
    private State moneyState;

    private State execute;

    public Context() {
        moneyState = new MoneyState(this);
        this.execute = moneyState;
    }

    public void giveMoney() {
        this.execute.giveMoney();
    }

    public void move() {
        this.execute.move();
    }

    public void grab() {
        this.execute.grab();
    }

    public void setExecute(State execute) {
        this.execute = execute;
    }
}