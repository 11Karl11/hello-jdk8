package hello.advance.pattern.observe.first;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 * Created on 2020-12-15 10:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FansObserver implements Observer {

    public String name;

    @Override
    public void update() {
        System.out.println("fans: " + this.name + "has get notice");
    }

}