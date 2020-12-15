package hello.advance.pattern.observe.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Observable;

/**
 * @author karl xie
 * Created on 2020-12-15 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObservableApp extends Observable {

    private long curr;

    void change(long newStr) {
        this.curr = newStr;

        //更改通知状态
        setChanged();
        notifyObservers(newStr);
    }

}