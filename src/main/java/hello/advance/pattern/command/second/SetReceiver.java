package hello.advance.pattern.command.second;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author karl xie
 * Created on 2020-12-16 17:59
 */
public class SetReceiver {
    OutputStream write;

    InputStream read;

    public void doCommand (String arg) {
        String[] strings = arg.split(" ");
        String key = strings[0];
        String val = strings[1];

        byte[] bytes = new byte[0];
        try {
            String sb = "*3" + SPILT +
                    "$3" + SPILT +
                    "SET" + SPILT +
                    "$" + key.getBytes().length + SPILT +
                    key + SPILT +
                    "$" + val.getBytes().length + SPILT +
                    val + SPILT;
            write.write(sb.getBytes());
            bytes = new byte[1024];
            read.read(bytes);
            System.out.println("Result: " + new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SetReceiver(OutputStream write, InputStream read) {
        this.write = write;
        this.read = read;
    }

    private final String SPILT = "\r\n";
}