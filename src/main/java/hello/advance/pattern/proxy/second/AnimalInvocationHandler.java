package hello.advance.pattern.proxy.second;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Date;

/**
 * @author karl xie
 */
public class AnimalInvocationHandler implements InvocationHandler {

    private Object object;

    public AnimalInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(MessageFormat.format("{0}.{1} -> log start time: {2}",
                object.getClass().getSimpleName(), method.getName(), new Date()));

        Object invoke = method.invoke(object, args);

        System.out.println(MessageFormat.format("{0}.{1} -> log end time: {2}",
                object.getClass().getSimpleName(), method.getName(), new Date()));
        return invoke;
    }
}