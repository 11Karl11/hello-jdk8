package hello.advance.pattern.template.first;

/**
 * @author karl xie
 * Created on 2020-12-21 17:00
 */
public class SuanRong extends TemplateClass {

    @Override
    boolean needSauce() {
        return false;
    }

    @Override
    void pourVegetable() {
        System.out.println("下锅的蔬菜是菜心");
    }

    @Override
    void pourSauce() {
        System.out.println("下锅的酱料是蒜蓉");
    }
}