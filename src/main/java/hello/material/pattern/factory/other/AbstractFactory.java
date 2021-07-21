package hello.material.pattern.factory.other;

import hello.material.pattern.factory.bean.AbstractFlat;
import hello.material.pattern.factory.bean.AbstractVilla;

/**
 * @author karl xie
 */
public interface AbstractFactory {

    AbstractFlat generateFlat();

    AbstractVilla generateVilla();

}