package hello.jdk8;

import hello.advance.example.fifth.PayHandlerChain;
import hello.advance.example.fifth.PayHandlerChain2;
import hello.advance.example.first.PayService1;
import hello.advance.example.fourth.PayService4;
import hello.advance.example.second.PayService2;
import hello.advance.example.third.PayService3;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * @author karl xie
 */
@SpringBootTest
public class ExampleTest {

    @Autowired
    private PayService1 payService1;

    @Autowired
    private PayService2 payService2;

    @Autowired
    private PayService3 payService3;

    @Autowired
    private PayService4 payService4;

    @Autowired
    private PayHandlerChain payHandlerChain;

    @Autowired
    private PayHandlerChain2 payHandlerChain2;

    @Test
    public void first() {
        payService1.pay("alia");
    }

    @Test
    public void second() {
        payService2.toPay("weixin");
    }

    @Test
    public void third() {
        payService3.toPay("weixin");
    }

    @Test
    public void fourth() {
        payService4.toPay("weixin");
    }

    @Test
    public void fifth() {
        payHandlerChain.handlePay("jingdong");
    }


    @Test
    public void fifth2() {
        payHandlerChain2.handlePay("first","jingdong", Lists.newArrayList("a","w","j","w"));
    }

    @Test
    public void other1() {
        save2(1, "1");

    }

    public void save2(Integer code, String name) {
        Assert.notNull(code, "code不能为空");
        Assert.notNull(name, "name不能为空");
        System.out.println("doSave");
    }
}