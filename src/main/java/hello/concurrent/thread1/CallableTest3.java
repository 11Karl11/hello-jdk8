package hello.concurrent.thread1;

/**
 * call()会阻塞
 * @author karl xie
 * Created on 2020-04-14 19:19
 */
import java.util.concurrent.Callable;

public class CallableTest3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.currentThread().sleep(5000);
        return "test callable HI";
    }

    public static void main(String[] args) throws Exception {
        CallableTest3 callableTest3 = new CallableTest3();
        String call = callableTest3.call();
        System.out.printf(call);
    }
}
