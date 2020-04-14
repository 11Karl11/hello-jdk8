package concurrent;

/**
 * @author karl xie
 * Created on 2020-04-14 20:03
 */
public class ThreadGroupTest2 {
    public static void main(String[] args) {
        System.out.println("当前线程组是:"+Thread.currentThread().getThreadGroup().getName());
    }
}