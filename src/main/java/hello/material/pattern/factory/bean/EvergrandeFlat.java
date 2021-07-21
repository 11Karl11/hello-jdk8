package hello.material.pattern.factory.bean;

/**
 * @author karl xie
 * Created on 2021-07-21 10:21
 */
@SuppressWarnings("all")
public class EvergrandeFlat extends AbstractFlat{


    @Override
    public void show() {
        System.out.println("恒大的公寓");
    }

    @Override
    public void showParlor() {
        System.out.println("恒大公寓的客厅");
    }
}