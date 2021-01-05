package hello.advance.pattern.state.first;

/**
 * @author karl xie
 */
public class MoveState implements State{

    Context context;

    public MoveState(Context context) {
        this.context = context;
    }

    @Override
    public void move() {
        System.out.println("正在移动滑杆, 确认！");
        changeState();
    }

    @Override
    public void changeState() {
        context.setExecute(new GrabState(context));
    }
}