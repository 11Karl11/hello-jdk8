package hello.material.pattern.factory.method;

import hello.material.pattern.factory.bean.AbstractFlat;
import hello.material.pattern.factory.bean.VankeFlat;

/**
 * @author karl xie
 */
@SuppressWarnings("all")
public class VankeFlatFactory extends Factory {

    @Override
    public AbstractFlat generateFlat() {
        return new VankeFlat();
    }
}