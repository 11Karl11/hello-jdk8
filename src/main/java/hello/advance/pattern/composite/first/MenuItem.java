package hello.advance.pattern.composite.first;

/**
 * @author karl xie
 * Created on 2021-01-05 10:05
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent component) throws Exception {
        throw new Exception("无法添加");
    }

    @Override
    public void remove(MenuComponent component) throws Exception {
        throw new Exception("无法移除");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public MenuComponent getChild(int i) throws Exception {
        throw new Exception("无子节点");
    }

    @Override
    public void print() {
        System.out.println("    食物名: " + getName());
    }
}