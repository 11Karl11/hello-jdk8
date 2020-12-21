package hello.advance.pattern.command.third;

/**
 * 具体命令（煮馄饨的命令）
 * @author karl xie
 * Created on 2020-12-21 16:08
 */
public class HunTun implements Food {
    Cooker cooker;

    public HunTun(Cooker cooker) {
        this.cooker = cooker;
    }
    @Override
    public void cook() {
        System.out.println("煮馄饨的命令发给厨师，等待厨师开煮...");
        cooker.cookHunTun();
    }
}