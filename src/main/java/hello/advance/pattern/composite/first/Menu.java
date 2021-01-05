package hello.advance.pattern.composite.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karl xie
 */
public class Menu extends MenuComponent {

    List<MenuComponent> menuComponents = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent component) {
        this.menuComponents.add(component);
    }

    @Override
    public void remove(MenuComponent component) {
        this.menuComponents.remove(component);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public void print() {
        System.out.println("当前菜单项: " + getName());
        for (MenuComponent component : menuComponents) {
            component.print();
        }
    }
}