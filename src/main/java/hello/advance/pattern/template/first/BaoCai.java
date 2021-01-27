package hello.advance.pattern.template.first;

/**
 * @author karl xie
 */
public class BaoCai extends TemplateClass {

    @Override
    void pourVegetable() {
        System.out.println("下锅的蔬菜是包菜");
    }

    @Override
    void pourSauce() {
        System.out.println("下锅的酱料是辣椒");
    }
}