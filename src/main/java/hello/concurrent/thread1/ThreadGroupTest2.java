package hello.concurrent.thread1;

import com.google.common.collect.Lists;

/**
 * @author karl xie
 * Created on 2020-04-14 20:03
 */
public class ThreadGroupTest2 {
    public static void main(String[] args) {
        System.out.println("当前线程组是:"+Thread.currentThread().getThreadGroup().getName());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());
        Thread[] threads = new Thread[threadGroup.activeCount()];
        //将ThreadGroup中活跃的线程引用复制到线程数组
        threadGroup.enumerate(threads);
        Lists.newArrayList(threads).stream().forEach(System.out::println);
    }
}