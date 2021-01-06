package hello.advance.pattern.factory.third;

import hello.advance.pattern.factory.bean.AbstractCPU;
import hello.advance.pattern.factory.bean.AbstractMotherboard;
import hello.advance.pattern.factory.bean.IntelCpu;
import hello.advance.pattern.factory.bean.IntelMotherboard;

/**
 * @author karl xie
 * Created on 2021-01-06 19:11
 */
public class IntelFactory extends AbstractFactory{

    @Override
    public AbstractCPU createCpu() {
        return new IntelCpu();
    }

    @Override
    public AbstractMotherboard createMotherboard() {
        return new IntelMotherboard();
    }
}