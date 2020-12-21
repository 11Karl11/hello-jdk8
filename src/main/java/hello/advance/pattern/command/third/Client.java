package hello.advance.pattern.command.third;

/**
 * 开发中常见的场景:
 *
 * 命令的撤销和恢复。
 *
 * Struts2中， action的整个调用过程中就有命令模式。
 *
 * 数据库事务机制的底层实现。
 *
 * @author karl xie
 * Created on 2020-12-21 16:09
 */
public class Client {

    public static void main(String[] args) {
        //厨师就绪
        Cooker cooker = new Cooker();
        Food chaoFan = new ChaoFan(cooker);
        Food hunTun = new HunTun(cooker);
        //服务员就绪
        Waiter waiter = new Waiter();
        //客户点了一个炒饭
        waiter.add(chaoFan);
        //又点了一个馄饨
        waiter.add(hunTun);
        //炒饭不想要了
        waiter.delete(chaoFan);
        //点好了开始做菜
        waiter.callCooking();
        //换一个新菜单为下一次点餐准备
        waiter.clear();
        System.out.println("---第二次点餐---");
        //重新又点了一个炒饭
        waiter.add(chaoFan);
        //点好开始做菜
        waiter.callCooking();
        //换一个新菜单为下一次点餐准备
        waiter.clear();
    }
}