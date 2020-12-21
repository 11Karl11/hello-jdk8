package hello.advance.pattern.command.first;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 * Created on 2020-12-16 17:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleRemoteControl {

    private Command slot;

    public void buttonWasPressed() {
        slot.execute();
    }

}