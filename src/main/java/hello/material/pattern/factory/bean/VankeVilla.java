package hello.material.pattern.factory.bean;

/**
 * @author karl xie
 * Created on 2021-07-21 10:20
 */
@SuppressWarnings("all")
public class VankeVilla extends AbstractVilla{


    @Override
    public void show() {
        System.out.println("万科的别墅");
    }

    @Override
    public void showParlor() {
        System.out.println("万科别墅的客厅");
    }
}