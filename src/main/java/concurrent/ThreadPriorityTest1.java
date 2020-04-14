package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.stream.IntStream;

/**
 * Java中线程优先级可以指定，范围是1~10。但是并不是所有的操作系统都⽀持10
 * 级优先级的划分（⽐如有些操作系统只⽀持3级划分：低，中，⾼），Java只是给 操作系统⼀个优先级的参考值，线程最终在操作系统的优先级是多少还是由操作系 统决定。
 * Java默认的线程优先级为5，线程的执⾏顺序由调度程序来决定，线程的优先级会 在线程被调⽤之前设定。 通常情况下，⾼优先级的线程将会⽐低优先级的线程有更⾼的⼏率得到执⾏。
 * 我们 使⽤⽅法 Thread 类的 setPriority() 实例⽅法来设定线程的优先级
 *
 * @author karl xie
 * Created on 2020-04-14 19:40
 */
@Slf4j
public class ThreadPriorityTest1 {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("默认的优先级" + thread.getPriority());
        Thread thread2 = new Thread();
        thread2.setPriority(10);
        System.out.println("设置过的优先级" + thread2.getPriority());
        /**
         * 既然有1-10的级别来设定了线程的优先级，这时候可能有些读者会问，那么我是不 是可以在业务实现的时候，采⽤这种⽅法来指定⼀些线程执⾏的先后顺序？
         * 对于这个问题，我们的答案是:No!
         * Java中的优先级来说不是特别的可靠，Java程序中对线程所设置的优先级只是给 操作系统⼀个建议，操作系统不⼀定会采纳。⽽真正的调⽤顺序，
         * 是由操作系统的 线程调度算法决定的。 我们通过代码来验证⼀下：
         */
        IntStream.range(1, 10).forEach(i -> {
            Thread t = new Thread(new T1());
            t.setPriority(i);
            t.start();
        });

    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            log.info("当前执行的线程是:{},优先级是:{}", Thread.currentThread().getName(), Thread.currentThread().getPriority());
        }
    }
}