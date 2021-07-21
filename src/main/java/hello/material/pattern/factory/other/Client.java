package hello.material.pattern.factory.other;

import hello.material.pattern.factory.bean.AbstractFlat;
import hello.material.pattern.factory.bean.AbstractVilla;
import hello.utils.CodeUtils;

/**
 * 优点：
 * 具体产品在应用层代码隔离，不需要关心产品细节。只需要知道自己需要的产品是属于哪个工厂的即可
 * 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。
 * 这对一些需要根据当前环境来决定其行为的软件系统来说，是一种非常实用的设计模式。
 *
 * 缺点：
 * 规定了所有可能被创建的产品集合，产品族中扩展新的产品困难，需要修改抽象工厂的接口。
 * 新增产品等级比较困难
 * 产品等级固定，而产品族不固定，扩展性强的场景。
 * @author karl xie
 */
public class Client {

    public static void main(String[] args) {
        VankeFactory vankeFactory = new VankeFactory();
        AbstractFlat abstractFlat = vankeFactory.generateFlat();
        abstractFlat.showParlor();

        CodeUtils.spilt();

        EvergrandeFactory evergrandeFactory = new EvergrandeFactory();
        AbstractVilla abstractVilla = evergrandeFactory.generateVilla();
        abstractVilla.show();
    }
}