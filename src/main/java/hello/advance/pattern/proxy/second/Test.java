package hello.advance.pattern.proxy.second;

import hello.advance.pattern.proxy.second.mybatis.MyBatis;
import hello.advance.pattern.proxy.second.mybatis.MybatisInvocation;
import hello.utils.CodeUtils;

import java.lang.reflect.Proxy;

/**
 * @author karl xie
 */
public class Test {

    /***
     * JDK 动态代理
     *
     * 注意事项:
     *     1.JDK动态代理的本质是创造一个实现了同一个接口的Proxy代理类，去进行真正的调用，只不过创造代理类的过程被底层隐藏了
     *     2.JDK动态代理在实现中的本质是反射技术
     *     3.由于所有的代理类都实现了Proxy.class -> 包括帮我们创造的代理类也是，因此由于JAVA单继承的特点，只能想要实现代理必须实现某一个接口
     *
     * 关键代码：
     *     1.代理类需要实现InvocationHandler接口，并拥有一个需要代理的实例对象
     *     2.真正调用时通过Proxy类进行调用  传递参数为：实现类类加载器，接口Class[]数组，以及实例化的处理器（InvokeHandler）
     *
     * 推荐代码阅读顺序：
     *
     * @see Animal
     * @see Cat
     * @see AnimalInvocationHandler
     *
     * MyBatis 代理接口Demo:
     *
     */
    public static void main(String[] args) {

        // 代理子类实现
        Animal cat = (Animal) Proxy.newProxyInstance(Cat.class.getClassLoader(),
                new Class[]{Animal.class}, new AnimalInvocationHandler(new Cat()));
        cat.eat("猫粮");

        CodeUtils.spilt();

        // JDK动态代理：模拟 MyBatis 核心代理阶段
        MyBatis batis = MybatisInvocation.newProxyInstance(MyBatis.class);
        System.out.println("Result:" + batis.select());
    }
}