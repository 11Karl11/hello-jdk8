package hello.advance.pattern.adapter.first;

import hello.utils.CodeUtils;

/**
 * @author karl xie
 * Created on 2021-01-05 22:16
 */
public class Test {


    /****
     * Tips：
     * 1. 需要注意适配器模式适配的是两个接口, 让其可以混在一起工作
     * 2. 和适配器模式很像的装饰模式, 是在一个接口场景下增强其方法功能等
     * 3. 适配器模式还有接口适配器的说法，请见：second
     *
     * JDK:
     * InputStreamReader类就有适配器的影子，官方说这个类是字节流通向字符流的桥梁
     * 其实按照适配器模式中的角色来看，它就是一个适配器，使得InputStream和Reader这两个接口可以一同工作
     *
     * 适配器模式
     *
     *
     */
    public static void main(String[] args){
        // 初始化的是火鸡对象, 但是伪装成鸭子对象
        WildTurkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);

        System.out.println("鸣叫:");
        duck.quack();

        CodeUtils.spilt();

        System.out.println("飞行：");
        duck.fly();
    }
}