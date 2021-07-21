package hello.material.pattern.factory.other;

import hello.material.pattern.factory.bean.AbstractFlat;
import hello.material.pattern.factory.bean.AbstractVilla;
import hello.material.pattern.factory.bean.EvergrandeFlat;
import hello.material.pattern.factory.bean.EvergrandeVilla;

/**
 * @author karl xie
 */
@SuppressWarnings("all")
public class EvergrandeFactory implements AbstractFactory{

    @Override
    public AbstractFlat generateFlat() {
        return new EvergrandeFlat();
    }

    @Override
    public AbstractVilla generateVilla() {
        return new EvergrandeVilla();
    }
}