package hello.advance.pattern.observe.second;

/**
 * @author karl xie
 * Created on 2020-12-15 11:14
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ObservableApp app = new ObservableApp(System.currentTimeMillis());
        System.out.println(app.getCurr());
        app.addObserver(new ObserverA());
        app.addObserver(new ObserverB());

        Thread.sleep(1000);
        long curr = System.currentTimeMillis();
        app.change(curr);
        System.out.println(app.getCurr());
    }
}