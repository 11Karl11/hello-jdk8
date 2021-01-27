package hello.advance.pattern.strategy.second;

/**
 * @author karl xie
 */
public abstract class Duck {

    /**
     * 飞行行为是动态的，可能会变的，因此抽成多个接口的组合，而不是让Duck类继承
     */
    FlyBehavior flyBehavior;

    /**
     * 每个鸭子的叫声不同，抽象成接口
     */
    QuackBehavior quackBehavior;

}