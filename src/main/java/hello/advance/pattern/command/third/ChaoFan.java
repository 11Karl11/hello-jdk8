package hello.advance.pattern.command.third;

/**
 * 具体命令（炒炒饭的命令）
 * @author karl xie
 * Created on 2020-12-21 16:07
 */
public class ChaoFan implements Food {

    Cooker cooker;

    public ChaoFan(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void cook() {
        System.out.println("炒炒饭的命令发给厨师，等待厨师开炒...");
        cooker.cookChaofan();
    }
}