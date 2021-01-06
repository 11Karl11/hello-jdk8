package hello.advance.pattern.proxy.third;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author karl xie
 */
public class PhoneCglibProxy implements MethodInterceptor {

    Object target;

    public PhoneCglibProxy(Object o) {
        this.target = o;
    }

    public Object newProxyInstance(){

        Enhancer en = new Enhancer();

        // 设置要代理的目标类
        en.setSuperclass(target.getClass());

        // 设置要代理的拦截器
        en.setCallback(this);

        // 生成代理类的实例
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(MessageFormat.format("Method Name is: {0} Params is: {1}", method.getName(), Arrays.toString(objects)));
        return methodProxy.invokeSuper(o, objects);
    }

}