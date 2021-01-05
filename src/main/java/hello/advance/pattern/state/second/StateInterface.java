package hello.advance.pattern.state.second;

/**
 * @author karl xie
 */
public interface StateInterface {

    /***
     * 不同状态下任务处理
     * @param context 当前上下文
     */
    void doAction(Context context);

    /***
     * 获取当前状态
     * @return StateEnums 状态枚举
     */
    StateEnums getCurrentState();

    /***
     * 输出当前状态
     */
    default void printCurrentState(){
        System.out.println("当前状态：" + getCurrentState().getDescr());
    }
}
