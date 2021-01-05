package hello.advance.pattern.state.second;

/**
 * @author karl xie
 */
public class Test {

    /***
     * 模拟场景：
     *          处理订单  处理成功  入库
     *    下单
     *          处理订单  处理失败  再处理(处理订单)
     *
     * 推荐代码阅读顺序：
     */
    public static void main(String[] args) {

        // 模拟从队列中取任务按流程循环执行
        Context context = new Context();
        while (true) {

            // 校验是否为废弃 | 已完成任务
            if (context.isAbandon()) {
                System.out.println("此条任务不再执行... ");
                break;
            }
            context.handle();
        }
    }
}