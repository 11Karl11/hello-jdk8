package hello.advance.pattern.proxy.third;

import hello.advance.pattern.proxy.first.PhoneServiceImpl;

/**
 * @author karl xie
 */
public class Test {

    /***
     * CGLIB动态代理
     *      如果类是final的，则无法生成代理对象，报错
     *      如果方法是final的，代理无效
     *
     * 关键代码：
     *     1.PhoneCglibProxy 实现 MethodInterceptor 方法拦截器接口  同时实现其 newProxyInstance方法 -> 该方法内容比较固定
     *     2.通过代理工厂构建, 创建对象, 使用即可
     *
     * Spring 3.2之后默认包含了cglib依赖
     * 普通项目 CGLIB依赖如下:
     *
     *     <dependency>
     *        <groupId>cglib</groupId>
     *        <artifactId>cglib-nodep</artifactId>
     *        <version>2.2.2</version>
     *     </dependency>
     *
     */
    public static void main(String[] args){
        PhoneServiceImpl phone = new PhoneServiceImpl();

        PhoneCglibProxy proxyFactory = new PhoneCglibProxy(phone);
        PhoneServiceImpl service = (PhoneServiceImpl) proxyFactory.newProxyInstance();
        service.updatePhone(15186564812L);
    }

}