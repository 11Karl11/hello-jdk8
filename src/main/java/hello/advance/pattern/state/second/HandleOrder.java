package hello.advance.pattern.state.second;

import hello.utils.CodeUtils;

/**
 * @author karl xie
 */
public class HandleOrder implements StateInterface{

    @Override
    public void doAction(Context context) {
        printCurrentState();

        // do somethings
        int num = (int) (Math.random() * 11);
        if (num >= 8) {
            System.out.println("处理订单完成, 进入成功状态...");
            context.setStateInterface(new SuccessOrder());
        } else {
            System.out.println("处理订单失败, 进入失败状态...");
            context.setStateInterface(new FailOrder());
        }

        CodeUtils.spilt();
    }

    @Override
    public StateEnums getCurrentState() {
        return StateEnums.HANDLE_ORDER;
    }
}