package concurrent.thread1;

/**
 * Java中⽤ThreadGroup来表示线程组，我们可以使⽤线程组对线程进⾏批量控制。
 * ThreadGroup和Thread的关系就如同他们的字⾯意思⼀样简单粗暴，每个Thread必 然存在于⼀个ThreadGroup中，Thread不能独⽴于ThreadGroup存在。执⾏main()
 * ⽅法线程的名字是main，如果在new Thread时没有显式指定，那么默认将⽗线程 （当前执⾏new Thread的线程）线程组设置为⾃⼰的线程组。
 *
 * ThreadGroup管理着它下⾯的Thread，ThreadGroup是⼀个标准的向下引⽤的树状 结构，这样设计的原因是防⽌"上级"线程被"下级"线程引⽤⽽⽆法有效地被GC回收。
 * @author karl xie
 * Created on 2020-04-14 19:35
 */
public class TestThreadGroup1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("当前线程组的名字:" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("当前线程的名字" + Thread.currentThread().getName());
        },"t1");
        t1.start();
        System.out.println("执行main方法的线程名字:"+Thread.currentThread().getName());
        System.out.println("执行main方法的线程组名字:"+Thread.currentThread().getThreadGroup().getName());

    }
}