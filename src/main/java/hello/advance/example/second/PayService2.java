package hello.advance.example.second;

import hello.advance.example.IPay;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 我们可以看到，支付类bean的名称是由code和后缀拼接而成，比如：aliaPay、weixinPay和jingDongPay。
 * 这就要求支付类取名的时候要特别注意，前面的一段要和code保持一致。调用的支付类的实例是直接从ApplicationContext实例中获取的，
 * 默认情况下bean是单例的，放在内存的一个map中，所以不会有性能问题。
 * 特别说明一下，这种方法实现了ApplicationContextAware接口跟上面的ApplicationListener接口不一样，是想告诉大家获取ApplicationContext实例的方法不只一种。
 *
 * @author karl xie
 */
@Service
public class PayService2 implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private static final String SUFFIX = "Pay";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void toPay(String payCode) {
        ((IPay) applicationContext.getBean(getBeanName(payCode))).pay();
    }

    public String getBeanName(String payCode) {
        return payCode + SUFFIX;
    }
}
