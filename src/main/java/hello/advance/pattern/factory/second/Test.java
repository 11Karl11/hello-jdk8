package hello.advance.pattern.factory.second;

import hello.utils.CodeUtils;

/**
 * @author karl xie
 * Created on 2021-01-06 19:08
 */
public class Test {

    /****
     * 工厂方法模式 (Factory Method Pattern)通过让子类决定该创建的对象是什么
     * 来达到将对象创建的国程封装的目的。
     *
     */
    public static void main(String[] args){
        Factory intelCpuFactory = new IntelCpuFactory();
        intelCpuFactory.orderCpu();

        CodeUtils.spilt();

        Factory amdCpuFactory = new AMDCpuFactory();
        amdCpuFactory.orderCpu();

    }
}