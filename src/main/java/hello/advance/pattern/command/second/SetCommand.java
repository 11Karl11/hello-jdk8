package hello.advance.pattern.command.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 * Created on 2020-12-16 18:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetCommand implements Command{

    private SetReceiver receiver;

    private String arg;

    @Override
    public void execute() {
        receiver.doCommand(this.arg);
    }
}