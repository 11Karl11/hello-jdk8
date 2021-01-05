package hello.advance.pattern.state.second;

import hello.utils.CodeUtils;

import java.text.MessageFormat;

/**
 * @author karl xie
 */
public class FailOrder implements StateInterface {

    @Override
    public void doAction(Context context) {
        printCurrentState();

        System.out.println(MessageFormat.format("订单处理失败... 当前执行次数: {0}", context.getFailNum()));

        // 大于3次丢弃
        if (context.getFailNum() >= Context.FAIL_NUM) {
            context.setAbandon(true);
        }

        // 处理次数加 1
        context.setFailNum(context.getFailNum() + 1);

        // 指向处理状态
        context.setStateInterface(new HandleOrder());

        CodeUtils.spilt();
    }

    @Override
    public StateEnums getCurrentState() {
        return StateEnums.FAIL_ORDER;
    }
}