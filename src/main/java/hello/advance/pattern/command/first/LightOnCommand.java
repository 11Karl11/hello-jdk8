package hello.advance.pattern.command.first;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karl xie
 * Created on 2020-12-16 17:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LightOnCommand implements Command{

    private Light light;

    @Override
    public void execute() {
        light.on();
    }
}