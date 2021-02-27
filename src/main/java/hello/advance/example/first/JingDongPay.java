package hello.advance.example.first;

import hello.advance.example.IPay;
import hello.advance.example.fourth.PayStrategyFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author karl xie
 */

@Service
@PayCode(value = "jingdong",name = "京东支付")
public class JingDongPay implements IPay {


    @Override
    public boolean support(String code) {
        return "jingdong".endsWith(code);
    }

    @Override
    public void pay() {
        System.out.println("==发起京东支付==");
    }

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("jingdong", this);
    }
}