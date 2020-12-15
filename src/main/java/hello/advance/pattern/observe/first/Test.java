package hello.advance.pattern.observe.first;

/**
 * @author karl xie
 * Created on 2020-12-15 10:56
 */
public class Test {

    public static void main(String[] args) {
        //build the object of subject
        WechatSubject subject = new WechatSubject();

        //add observer for the object of subject
        subject.attach(new FansObserver("xiao zhang"));
        subject.attach(new FansObserver("xiao hong"));
        subject.attach(new FansObserver("xiao ming"));

        //模拟一个业务场景
        if (Math.random()*11>3){
            System.out.println("wechat 只是执行普通的业务");
            subject.doSomething();
        }else {
            System.out.println("wechat 触发发送通知机制");
            subject.sendNotify();
        }

    }
}