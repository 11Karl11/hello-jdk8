package hello.advance.pattern.proxy.first;

/**
 * @author karl xie
 */
public class PhoneServiceImpl implements PhoneInterface {

    @Override
    public void updatePhone(Long phoneNum) {
        System.out.println("update phoneNum is: -> " + phoneNum);
    }
}