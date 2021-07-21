package hello.material.pattern.factory.bean;

/**
 * @author karl xie
 * Created on 2021-07-21 10:20
 */
@SuppressWarnings("all")
public class VankeFlat extends AbstractFlat{


    @Override
    public void show() {
        System.out.println("万科的公寓");
    }

    @Override
    public void showParlor() {
        System.out.println("万科公寓的客厅");
    }
}