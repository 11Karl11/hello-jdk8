package hello.genericity;

/**
 *  泛型接口的实现类，如果没有指定具体的类型,可以默认是object类型
 * @author karl xie
 */
public class PerIntImpl2 implements PerInt{

    @Override
    public void show(Object name) {
        System.out.println(name);
    }
}