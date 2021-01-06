package hello.advance.pattern.factory.first;

import hello.advance.pattern.factory.bean.AMDCpu;
import hello.advance.pattern.factory.bean.AbstractCPU;
import hello.advance.pattern.factory.bean.IntelCpu;

/**
 * @author karl xie
 * Created on 2021-01-06 18:58
 */
public class SimpleFactory {

    public static AbstractCPU createCpu(String type) {
        switch (type) {
            case "INTEL":
                return new IntelCpu();
            default:
                return new AMDCpu();
        }

    }
}