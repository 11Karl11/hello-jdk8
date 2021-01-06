package hello.advance.pattern.factory.third;

import hello.advance.pattern.factory.bean.AMDCpu;
import hello.advance.pattern.factory.bean.AMDMotherboard;
import hello.advance.pattern.factory.bean.AbstractCPU;
import hello.advance.pattern.factory.bean.AbstractMotherboard;

/**
 * @author karl xie
 * Created on 2021-01-06 19:10
 */
public class AMDFactory extends AbstractFactory{

    @Override
    public AbstractCPU createCpu() {
        return new AMDCpu();
    }

    @Override
    public AbstractMotherboard createMotherboard() {
        return new AMDMotherboard();
    }
}