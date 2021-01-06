package hello.advance.pattern.facade;

import hello.utils.CodeUtils;

/**
 *
 * 什么场景适用
 * 需要为一个复杂的子系统提供一个简单接口时
 * 客户程序与抽象类的实现部分之间存在着很大依赖性（分离逻辑，提高子系统的独立性和可移植性）
 * 需要构建一个层次结构的子系统时
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        // 不使用外观模式
        Computer cpu = new Cpu();
        Computer ram = new Ram();
        Computer ssd = new Ssd();
        cpu.open();
        ram.open();
        ssd.open();

        CodeUtils.spilt();

        // 使用外观模式
        FacadeComputer facadeComputer = new FacadeComputer();
        facadeComputer.allOn();
    }
}