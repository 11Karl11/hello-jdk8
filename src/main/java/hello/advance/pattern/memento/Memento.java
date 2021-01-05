package hello.advance.pattern.memento;

import java.util.Map;

/**
 * @author karl xie
 * Created on 2021-01-05 21:33
 */
public class Memento {

    Map<String, String> data;

    public Memento (Map<String, String> data) {
        this.data = data;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}