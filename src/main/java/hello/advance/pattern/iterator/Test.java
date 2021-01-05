package hello.advance.pattern.iterator;

import hello.utils.CodeUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args){
        // 餐厅菜单
        FoodRepository food = new FoodRepository();
        MyIterator foodIterator = food.getIterator();
        while (foodIterator.hasNext()) {
            System.out.println("Food: -> " + foodIterator.next());
        }

        CodeUtils.spilt();

        // 咖啡菜单
        CoffeeRepository coffee = new CoffeeRepository();
        MyIterator coffeeIterator = coffee.getIterator();
        while (coffeeIterator.hasNext()) {
            System.out.println("Coffee: -> " + coffeeIterator.next());
        }

        CodeUtils.spilt();

        // JDK
        List<String> names = Arrays.asList("Han", "John", "Tomams");
        Iterator<String> iterable = names.iterator();
        while (iterable.hasNext()) {
            System.out.println("JDK Iterator: -> " + iterable.next());
        }

        CodeUtils.spilt();

        // JDK
        names.forEach(s -> System.out.println("JDK forEach: -> " + s));
    }
}