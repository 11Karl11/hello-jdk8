package hello.material.pattern.factory.method;

import hello.material.pattern.factory.bean.AbstractFlat;
import hello.material.pattern.factory.bean.EvergrandeFlat;

/**
 * @author karl xie
 * Created on 2021-07-21 10:52
 */
@SuppressWarnings("all")
public class EvergrandeFlatFactory extends Factory {

    @Override
    public AbstractFlat generateFlat() {
        return new EvergrandeFlat();
    }
}