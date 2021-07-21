package hello.advance.demo;

import hello.advance.pattern.factory.bean.AMDCpu;
import hello.advance.pattern.factory.bean.AbstractCPU;
import hello.advance.pattern.factory.bean.IntelCpu;

/**
 * @author karl xie
 */
public class SimpleFactory {

    public static AbstractCPU createCpu (String type) {
        switch (type) {
            case "INTEL":
                return new IntelCpu();
            default:
                return new AMDCpu();
        }

       /* if ("INTEL".equals(type)) {
            return new IntelCpu();
        } else if ("AMD".equals(type)){
            return new AMDCpu();
        }
        return null;*/
    }
}
