package hello.advance.pattern.factory.second;

import hello.advance.pattern.factory.bean.AbstractCPU;
import hello.advance.pattern.factory.bean.IntelCpu;

/**
 * @author karl xie
 * Created on 2021-01-06 19:07
 */
public class IntelCpuFactory extends Factory{

    @Override
    public AbstractCPU generateCpu() {
        return new IntelCpu();
    }
}