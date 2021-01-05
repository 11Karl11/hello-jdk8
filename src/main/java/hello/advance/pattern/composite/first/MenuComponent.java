package hello.advance.pattern.composite.first;

/**
 * @author karl xie
 */
public abstract class MenuComponent {

    public String name;

    /***
     * 添加
     */
    public abstract void add(MenuComponent component) throws Exception;

    /***
     * 移除
     */
    public abstract void remove(MenuComponent component) throws Exception;

    /***
     * 获取菜单名
     */
    public abstract String getName();

    /***
     * 获取子菜单
     */
    public abstract MenuComponent getChild(int i) throws Exception;

    /***
     * 打印菜单
     */
    public abstract void print();

}