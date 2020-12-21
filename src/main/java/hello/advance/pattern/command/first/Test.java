package hello.advance.pattern.command.first;

/**
 * @author karl xie
 * Created on 2020-12-16 17:51
 */
public class Test {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();

        LightOnCommand lightOn = new LightOnCommand(light);
        remote.setSlot(lightOn);
        remote.buttonWasPressed();

        LightOffCommand lightOff = new LightOffCommand(light);
        remote.setSlot(lightOff);
        remote.buttonWasPressed();
    }
}