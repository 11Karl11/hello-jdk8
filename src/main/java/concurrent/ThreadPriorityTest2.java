package concurrent;

/**
 * Java提供⼀个线程调度器来监视和控制处于RUNNABLE状态的线程。线程的调度 策略采⽤抢占式，优先级⾼的线程⽐优先级低的线程会有更⼤的⼏率优先执⾏。
 * 在 优先级相同的情况下，按照“先到先得”的原则。每个Java程序都有⼀个默认的主线 程，就是通过JVM启动的第⼀个线程main线程。 还有⼀种线程称为守护线程（Daemon），
 * 守护线程默认的优先级⽐较低。
 * <p>
 * 如果某线程是守护线程，那如果所有的⾮守护线程结束，这个守护线程也会
 * ⾃动结束。 应⽤场景是：当所有⾮守护线程结束时，结束其余的⼦线程（守护线程）⾃
 * 动关闭，就免去了还要继续关闭⼦线程的麻烦。
 * ⼀个线程默认是⾮守护线程，可以通过Thread类的setDaemon(boolean on)
 * 来设置。
 *
 * @author karl xie
 * Created on 2020-04-14 19:50
 */
public class ThreadPriorityTest2 {
    public static void main(String[] args) {
        //在之前，我们有谈到⼀个线程必然存在于⼀个线程组中，那么当线程和线程组的优 先级不⼀致的时候将会怎样呢？我们⽤下⾯的案例来验证⼀下：

        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);

        Thread thread1 = new Thread(threadGroup, "thread1");
        thread1.setPriority(9);
        Thread thread2 = new Thread(() -> {
        }, "thread2");
        thread2.setPriority(8);
        System.out.println("线程组的优先级:" + threadGroup.getMaxPriority());
        System.out.println("线程1的优先级:" + thread1.getPriority() + "所属线程组" + thread1.getThreadGroup().getName());
        System.out.println("线程2的优先级:" + thread2.getPriority() + "所属线程组" + thread2.getThreadGroup().getName());
        //所以，如果某个线程优先级⼤于线程所在线程组的最⼤优先级，那么该线程的优先 级将会失效，取⽽代之的是线程组的最⼤优先级。

    }
}