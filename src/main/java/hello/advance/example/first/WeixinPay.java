package hello.advance.example.first;

import hello.advance.example.IPay;
import hello.advance.example.fourth.PayStrategyFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author karl xie
 */

@Service
@PayCode(value = "weixin",name = "微信支付")
public class WeixinPay implements IPay {

    @Override
    public boolean support(String code) {
        return "weixin".endsWith(code);
    }

    @Override
    public void pay() {
        System.out.println("==发起微信支付==");
    }

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("weixin", this);
    }
}