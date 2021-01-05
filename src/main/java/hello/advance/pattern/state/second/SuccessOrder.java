package hello.advance.pattern.state.second;

import hello.utils.CodeUtils;

/**
 * @author karl xie
 */
public class SuccessOrder implements StateInterface{

    @Override
    public void doAction(Context context) {
        printCurrentState();

        System.out.println("订单处理完成 -> 进入入库逻辑...");
        System.out.println("入库处理完成");
        // 处理成功 不再处理
        context.setAbandon(true);

        CodeUtils.spilt();
    }

    @Override
    public StateEnums getCurrentState() {
        return StateEnums.SUCCESS_ORDER;
    }
}