package hello.advance.example.fifth;

import org.springframework.stereotype.Service;

/**
 * @author karl xie
 */
@Service
public class JingdongPayHandler extends PayHandler{

    {
        super.priority = 1;
    }

    @Override
    public void pay(String code) {
        if ("jingdong".equals(code)) {
            System.out.println("===发起京东支付===");
        } else {
            getNext().pay(code);
        }
    }

    @Override
    public boolean pay2(String code) {
        if ("jingdong".equals(code)) {
            System.out.println("===发起京东支付===");
            return true;
        }
        return false;
    }

}