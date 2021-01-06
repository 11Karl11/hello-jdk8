package hello.advance.pattern.factory.second;

import hello.advance.pattern.factory.bean.AMDCpu;
import hello.advance.pattern.factory.bean.AbstractCPU;

/**
 * @author karl xie
 * Created on 2021-01-06 19:07
 */
public class AMDCpuFactory extends Factory{

    @Override
    public AbstractCPU generateCpu() {
        return new AMDCpu();
    }
}