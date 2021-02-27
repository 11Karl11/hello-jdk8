package hello.advance.example.first;

import hello.advance.example.IPay;
import hello.advance.example.fourth.PayStrategyFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author karl xie
 */

@Service
@PayCode(value = "alia",name = "支付宝支付")
public class AliaPay implements IPay {

    @Override
    public boolean support(String code) {
        return "alia".endsWith(code);
    }

    @Override
    public void pay() {
        System.out.println("==发起支付宝支付==");
    }

    @PostConstruct
    public void init() {
        PayStrategyFactory.register("aliaPay", this);
    }
}