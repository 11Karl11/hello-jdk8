package hello.advance.pattern.state.first;

/**
 * @author karl xie
 */
public class GrabState implements State{

    Context context;

    public GrabState(Context context) {
        this.context = context;
    }

    @Override
    public void grab() {
        System.out.println("抓取娃娃!");
        changeState();
    }

    @Override
    public void changeState() {
        context.setExecute(new MoneyState(context));
    }
}