package hello.advance.pattern.observe.first;

/**
 * 主题/目标
 * @author karl xie
 * Created on 2020-12-15 10:48
 */
public interface Subject {

    //add observer
    void attach(Observer observer);

    //remove observer
    void detach(Observer observer);

    //send notify to observers
    void sendNotify();


}
