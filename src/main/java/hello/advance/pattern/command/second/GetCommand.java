package hello.advance.pattern.command.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 * Created on 2020-12-16 17:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCommand implements Command{

    private GetReceiver receiver;

    private String arg;

    @Override
    public void execute() {
        receiver.doCommand(arg);
    }
}