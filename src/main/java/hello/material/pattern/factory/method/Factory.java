package hello.material.pattern.factory.method;

import hello.material.pattern.factory.bean.AbstractFlat;

/**
 * @author karl xie
 */
public abstract class Factory {

    public void visit() {

        AbstractFlat abstractFlat = generateFlat();
        abstractFlat.show();
        abstractFlat.showParlor();
        //.....
    }

    public abstract AbstractFlat generateFlat();
}