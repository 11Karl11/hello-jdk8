package hello.advance.example.first;

import hello.advance.example.IPay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * PayService2类实现了ApplicationListener接口，这样在onApplicationEvent方法中，就可以拿到ApplicationContext的实例。我们再获取打了PayCode注解的类，放到一个map中，map中的key就是PayCode注解中定义的value，跟code参数一致，value是支付类的实例。
 * 这样，每次就可以每次直接通过code获取支付类实例，而不用if...else判断了。如果要加新的支付方法，只需在支付类上面打上PayCode注解定义一个新的code即可。
 * 注意：这种方式的code可以没有业务含义，可以是纯数字，只要不重复就行。
 *
 * @author karl xie
 */
@Service
public class PayService1 implements ApplicationListener<ContextRefreshedEvent> {

    private static Map<String, IPay> payMap = null;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(PayCode.class);

        if (beansWithAnnotation != null) {
            payMap = new HashMap<>();
            beansWithAnnotation.forEach((key, value) -> {
                String bizType = value.getClass().getAnnotation(PayCode.class).value();
                payMap.put(bizType, (IPay) value);
            });
        }

    }

    public void pay(String code) {
        payMap.get(code).pay();
    }
}