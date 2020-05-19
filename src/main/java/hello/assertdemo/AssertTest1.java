package hello.assertdemo;

/**
 * 在VM栏里输入 -enableassertions 或者 -ea 就好了
 * @author karl xie
 * Created on 2020-05-19 14:06
 */
public class AssertTest1 {

    public static void main(String[] args) {
        boolean isOpen = false;

        // 如果开启了断言，会将isOpen的值改为true
        assert isOpen = true;

        // 打印是否开启了断言，如果为false，则没有启用断言
        System.out.println(isOpen);
    }
}