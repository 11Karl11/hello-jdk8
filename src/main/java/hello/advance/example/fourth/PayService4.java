package hello.advance.example.fourth;

import org.springframework.stereotype.Service;

/**
 * @author karl xie
 */
@Service
public class PayService4 {

    public void toPay(String code) {
        PayStrategyFactory.get(code).pay();
    }
}