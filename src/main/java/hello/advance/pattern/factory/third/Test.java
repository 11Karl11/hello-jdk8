package hello.advance.pattern.factory.third;

import hello.utils.CodeUtils;

/**
 * @author karl xie
 * Created on 2021-01-06 19:11
 */
public class Test {

    /****
     * 抽象工厂模式 -> 产品族维度
     *
     */
    public static void main(String[] args){
        AbstractFactory intel = new IntelFactory();
        intel.createCpu().show();
        intel.createMotherboard().show();

        CodeUtils.spilt();

        AbstractFactory amd = new AMDFactory();
        amd.createCpu().show();
        amd.createMotherboard().show();
    }
}