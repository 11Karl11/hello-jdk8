package hello.advance.pattern.observe.first;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 存储观察者对象。
 * 当内部状态改变时，给所有登记过的观察者发出通知。
 * 具体目标通常用一个具体子类实现。
 *
 * @author karl xie
 * Created on 2020-12-15 10:52
 */
public class WechatSubject implements Subject {

    List<Observer> observers = Lists.newArrayList();

    void doSomething() {
        //模拟业务逻辑
        System.out.println("假装我发了一篇公众号文章！");
    }



    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendNotify() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}