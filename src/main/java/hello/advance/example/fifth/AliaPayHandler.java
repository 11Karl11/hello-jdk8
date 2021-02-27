package hello.advance.example.fifth;

import org.springframework.stereotype.Service;

/**
 * @author karl xie
 */
@Service
public class AliaPayHandler extends PayHandler{

    @Override
    public void pay(String code) {
        if ("alia".equals(code)) {
            System.out.println("===发起支付宝支付===");
        } else {
            getNext().pay(code);
        }
    }

}