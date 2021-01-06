package hello.advance.pattern.proxy.first;

import hello.utils.CodeUtils;

/**
 * @author karl xie
 */
public class Test {

    /***
     * 代理模式之静态代理
     *
     */
    public static void main(String[] args) {
        PhoneInterface proxy = new PhoneServiceProxy();
        proxy.updatePhone(15186564812L);

        CodeUtils.spilt();

        proxy.updatePhone(null);
    }
}