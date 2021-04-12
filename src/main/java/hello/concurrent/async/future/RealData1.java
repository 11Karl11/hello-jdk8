package hello.concurrent.async.future;

import java.util.concurrent.Callable;

/**
 * @author karl xie
 */
public class RealData1 implements Callable<String> {

    private final String name;

    public RealData1(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return name + "执行完毕";
    }
}

