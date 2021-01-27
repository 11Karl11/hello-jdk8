package hello.advance.pattern.strategy.third;

/**
 * 结论：策略模式定义一系列算法，他们完成的都是同一件事，只是实现方法不同，比如超市收银时，会员打折，非会员不打折，实现的都是收钱，实现方法（打折/非打折）不同。
 * 优点：1.上下文和具体策略是松耦合关系。因此上下文只知道它要使用某一个实现Strategy接口类的实例，但不需要知道具体是哪一个类。
 *      2.策略模式满足“开-闭原则”。当增加新的具体策略时，不需要修改上下文类的代码，上下文就可以引用新的具体策略的实例。
 * @author karl xie
 */
public class Test2 {

    public static void main(String[] args) {
        Context2 context2A = new Context2("A");
        context2A.contextInterface();
        Context2 context2B = new Context2("B");
        context2B.contextInterface();
    }
}