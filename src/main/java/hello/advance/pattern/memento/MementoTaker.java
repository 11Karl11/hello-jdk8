package hello.advance.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karl xie
 * Created on 2021-01-05 21:33
 */
public class MementoTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

}