package hello.advance.example.fifth;

import lombok.Getter;
import lombok.Setter;

/**
 * @author karl xie
 */
public abstract class PayHandler {

    protected Integer priority;

    @Getter
    @Setter
    protected PayHandler next;

    public abstract void pay(String pay);
}