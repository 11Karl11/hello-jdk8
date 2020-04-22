package hello.demo;

import java.util.stream.Stream;

/**
 * 创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。
 * @author karl xie
 * Created on 2020-04-21 16:51
 */
public class ThreadNameTest extends Thread {

    public ThreadNameTest() {
        super.setName("testThread");
    }

    public static void main(String[] args) {
        Stream.of(1, 2, 3).forEach(t -> {
            ThreadNameTest threadNameTest = new ThreadNameTest();
            System.out.println(threadNameTest.getName());

        });
    }
}