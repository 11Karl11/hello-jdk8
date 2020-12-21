package hello.advance.pattern.command.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令发出者（服务员）
 *
 * @author karl xie
 * Created on 2020-12-21 16:09
 */
public class Waiter {

    //菜单
    private List<Food> menu = new ArrayList<>();

    public void add(Food food) {
        menu.add(food);
    }

    public void delete(Food food) {
        menu.remove(food);
    }

    public void clear() {
        menu.clear();
    }

    //把菜单交给厨师，让厨师做上面的菜
    public void callCooking() {
        for (Food food : menu) {
            food.cook();
        }
    }
}