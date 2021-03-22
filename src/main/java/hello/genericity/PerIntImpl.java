package hello.genericity;

/**
 * 泛型接口的实现类可以指定具体的泛型接口类型
 * 泛型接口的实现类，如果没有指定具体的类型，必须要在实现类中声明一个泛型类型占位符
 * @author karl xie
 */
public class PerIntImpl implements PerInt<String> {


    @Override
    public void show(String name) {
        System.out.println(name);
    }
}