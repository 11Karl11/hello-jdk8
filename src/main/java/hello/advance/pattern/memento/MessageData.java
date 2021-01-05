package hello.advance.pattern.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * @author karl xie
 * Created on 2021-01-05 21:33
 */
public class MessageData {

    private String time;

    private String message;

    /**
     * 存储数据
     */
    public Memento saveMemento () {
        Map<String, String> map = new HashMap<>();
        map.put("TIME",    time);
        map.put("MESSAGE", message);
        return new Memento(map);
    }

    /**
     * 取出数据
     */
    public void getFromMemento(Memento memento){
        time    = memento.getData().get("TIME");
        message = memento.getData().get("MESSAGE");
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "time='" + time + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}