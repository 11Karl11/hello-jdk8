package hello.advance.pattern.proxy.first;

/**
 * @author karl xie
 */
public interface PhoneInterface {

    /***
     * 更新电话号码
     * @param phoneNum    电话号码
     * @throws Exception  可能抛出Exception 异常
     */
    void updatePhone(Long phoneNum);
}