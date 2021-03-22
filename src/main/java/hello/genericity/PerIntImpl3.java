package hello.genericity;

/**
 * 泛型接口的实现类，如果没有指定具体的类型，须要在实现类中声明一个泛型类型占位符
 * @author karl xie
 */
public class PerIntImpl3<W> implements PerInt<W> {

    @Override
    public void show(W name) {
        System.out.println(name);
    }
}