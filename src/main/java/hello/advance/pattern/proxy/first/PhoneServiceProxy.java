package hello.advance.pattern.proxy.first;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author karl xie
 */
public class PhoneServiceProxy implements PhoneInterface{


    /** 代理模式一般自行New对象, 反观装饰器模式则是传入对象 **/
    private PhoneInterface phoneInterface;

    public PhoneServiceProxy() {
        this.phoneInterface = new PhoneServiceImpl();
    }

    @Override
    public void updatePhone(Long phoneNum) {
        before(phoneNum);
        phoneInterface.updatePhone(phoneNum);
        after();
    }

    private void before(Long phoneNum) {
        System.out.println(MessageFormat.format("log start time:{0} , phoneNum is: {1}", new Date(), phoneNum));
        if (null == phoneNum || String.valueOf(phoneNum).length() != 11) {
            throw new RuntimeException("Update phoneNum fail, phoneNum is wrong.");
        }
    }

    private void after() {
        System.out.println(MessageFormat.format("log end time:{0}", new Date()));
    }
}