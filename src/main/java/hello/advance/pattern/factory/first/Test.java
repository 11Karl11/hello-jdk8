package hello.advance.pattern.factory.first;

/**
 * @author karl xie
 * Created on 2021-01-06 19:03
 */
public class Test {

    /***
     * 简单工厂模式不属于23种设计模式, 它仅仅是把对象的调用和生产进行了初步解耦
     *
     * 简单来说就是把创建对象的细节屏蔽到工厂之中, 仅此而已
     *
     */
    public static void main(String[] args){
        SimpleFactory.createCpu("INTEL").show();
        SimpleFactory.createCpu("AMD").show();
    }
}