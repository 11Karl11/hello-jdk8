package hello.advance.pattern.factory.second;

import hello.advance.pattern.factory.bean.AbstractCPU;

/**
 * @author karl xie
 * Created on 2021-01-06 19:07
 */
public abstract class Factory {

    /***
     * 产品订购方案
     */
    public AbstractCPU orderCpu () {
        AbstractCPU cpu = generateCpu();
        cpu.show();
        cpu.prepare();
        cpu.box();

        // 假设有相同的业务处理逻辑...
        return cpu;
    }

    protected abstract AbstractCPU generateCpu();
}