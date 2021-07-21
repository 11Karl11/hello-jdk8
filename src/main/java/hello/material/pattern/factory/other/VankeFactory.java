package hello.material.pattern.factory.other;

import hello.material.pattern.factory.bean.AbstractFlat;
import hello.material.pattern.factory.bean.AbstractVilla;
import hello.material.pattern.factory.bean.VankeFlat;
import hello.material.pattern.factory.bean.VankeVilla;

/**
 * @author karl xie
 */
@SuppressWarnings("all")
public class VankeFactory implements AbstractFactory {

    @Override
    public AbstractFlat generateFlat() {
        return new VankeFlat();
    }

    @Override
    public AbstractVilla generateVilla() {
        return new VankeVilla();
    }
}