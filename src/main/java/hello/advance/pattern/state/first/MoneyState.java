package hello.advance.pattern.state.first;

/**
 * @author karl xie
 */
public class MoneyState implements State{

    Context context;

    public MoneyState(Context context) {
        this.context = context;
    }

    @Override
    public void giveMoney() {
        System.out.println("已投币!");
        changeState();
    }

    @Override
    public void changeState() {
        context.setExecute(new MoveState(context));
    }
}