package hello.advance.example.fifth;

import org.springframework.stereotype.Service;

/**
 * @author karl xie
 */
@Service
public class AliaPayHandler extends PayHandler {

    {
        super.priority = 2;
    }


    @Override
    public void pay(String code) {
        if ("alia".equals(code)) {
            System.out.println("===发起支付宝支付===");
        } else {
            getNext().pay(code);
        }
    }

    @Override
    public boolean pay2(String code) {
        if ("alia".equals(code)) {
            System.out.println("===发起支付宝支付===");
            return true;
        }
        return false;
    }

}