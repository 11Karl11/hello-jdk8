package hello.advance.example.fifth;

import org.springframework.stereotype.Service;

/**
 * @author karl xie
 */
@Service
public class WeixinPayHandler extends PayHandler{

    {
        super.priority = 3;
    }

    @Override
    public void pay(String code) {
        if ("weixin".equals(code)) {
            System.out.println("===发起微信支付===");
        } else {
            getNext().pay(code);
        }
    }


    @Override
    public boolean pay2(String code) {
        if ("weixin".equals(code)) {
            System.out.println("===发起微信支付===");
            return true;
        }
        return false;
    }

}