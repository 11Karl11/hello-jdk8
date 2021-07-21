package hello.material.pattern.factory.method;

import hello.utils.CodeUtils;

/**
 * 工厂方法模式是为了克服简单工厂模式的缺点（主要是为了满足开闭原则）而设计出来的。
 * 简单工厂模式的工厂类随着产品类的增加需要增加很多方法（或代码），而工厂方法模式每个具体工厂类只完成单一任务，代码简洁。
 * 工厂方法模式完全满足开闭原则，即它有非常良好的扩展性。
 * 但是工厂方法模式缺点也很明显，假如某个具体产品类需要进行一定的修改，很可能需要修改对应的工厂类。
 * 当同时需要修改多个产品类的时候，对工厂类的修改会变得相当麻烦。
 * 比如说，每增加一个产品，相应的也要增加一个子工厂，会加大了额外的开发量，也会导致类爆炸。
 *
 * @author karl xie
 */
public class Client {

    public static void main(String[] args) {
        VankeFlatFactory vankeFlatFactory = new VankeFlatFactory();
        vankeFlatFactory.visit();
        CodeUtils.spilt();
        EvergrandeFlatFactory evergrandeFlatFactory = new EvergrandeFlatFactory();
        evergrandeFlatFactory.visit();
    }
}