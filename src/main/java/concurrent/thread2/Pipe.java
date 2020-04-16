package concurrent.thread2;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道是基于“管道流”的通信⽅式。JDK提供了 PipedWriter 、 PipedReader 、
 * PipedOutputStream 、 PipedInputStream 。其中，前⾯两个是基于字符的，后⾯两 个是基于字节流的。 这⾥的示例代码使⽤的是基于字符的：
 * @author karl xie
 * Created on 2020-04-15 20:43
 */
public class Pipe {
    static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable {
        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("this is writer");
            int receive = 0;
            try {
                writer.write("test111111111111111111111111");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 我们通过线程的构造函数，传⼊了 PipedWrite 和 PipedReader 对象。可以简单分析
     * ⼀下这个示例代码的执⾏流程： 1. 线程ReaderThread开始执⾏，
     * 2. 线程ReaderThread使⽤管道reader.read()进⼊”阻塞“，
     * 3. 线程WriterThread开始执⾏，
     * 4. 线程WriterThread⽤writer.write("test")往管道写⼊字符串，
     * 5. 线程WriterThread使⽤writer.close()结束管道写⼊，并执⾏完毕，
     * 6. 线程ReaderThread接受到管道输出的字符串并打印，
     * 7. 线程ReaderThread执⾏完毕。
    */
    public static void main(String[] args) throws IOException, InterruptedException {

        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader); // 这⾥注意⼀定要连接，才能通信
        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }

    /**
     * 管道通信的应⽤场景： 这个很好理解。使⽤管道多半与I/O流相关。
     * 当我们⼀个线程需要先另⼀个线程发 送⼀个信息（⽐如字符串）或者⽂件等等时，就需要使⽤管道通信了。
    */
}