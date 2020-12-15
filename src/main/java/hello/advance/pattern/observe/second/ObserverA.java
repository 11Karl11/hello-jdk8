package hello.advance.pattern.observe.second;

import java.text.MessageFormat;
import java.util.Observable;
import java.util.Observer;

/**
 * @author karl xie
 * Created on 2020-12-15 11:12
 */
public class ObserverA implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(
                MessageFormat.format("ObserverA -> {0} changed, Begin to Work. agr is:{1}",
                        o.getClass().getSimpleName(), arg));
    }
}