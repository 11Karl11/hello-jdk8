package hello.advance.pattern.factory.third;

import hello.advance.pattern.factory.bean.AbstractCPU;
import hello.advance.pattern.factory.bean.AbstractMotherboard;

/**
 * @author karl xie
 * Created on 2021-01-06 19:10
 */
public abstract class AbstractFactory {

    /**
     * 创建CPU对象
     * @return CPU对象
     */
    public abstract AbstractCPU createCpu();

    /**
     * 创建主板对象
     * @return 主板对象
     */
    public abstract AbstractMotherboard createMotherboard();
}