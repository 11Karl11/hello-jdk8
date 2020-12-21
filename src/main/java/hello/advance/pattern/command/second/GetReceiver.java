package hello.advance.pattern.command.second;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author karl xie
 * Created on 2020-12-16 17:58
 */
public class GetReceiver {

    OutputStream write;

    InputStream read;

    public void doCommand(String arg) {
        String[] strings = arg.split(" ");
        String key = strings[0];
        byte[] bytes;
        try {
            String sb = "*2" + SPILT +
                    "$3" + SPILT +
                    "GET" + SPILT +
                    "$" + key.getBytes().length + SPILT +
                    key + SPILT;
            write.write(sb.getBytes());
            bytes = new byte[1024];
            read.read(bytes);
            System.out.println("Result: " + new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GetReceiver(OutputStream write, InputStream read) {
        this.write = write;
        this.read = read;
    }

    final String SPILT = "\r\n";
}