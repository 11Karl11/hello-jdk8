package hello.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.Socket;

/**
 * @author karl xie
 * Created on 2020-03-25 15:17
 */
@Slf4j
public class ProtocolTest {

    public static void main(String[] args) throws IOException {

        Integer size = 6;

        // 1.进行循环遍历.获取所有文件
        for (int i = 1; i <= size; i++) {
            String s = readToMultipart(new File("D:\\data\\file\\gpxx\\" + i +".txt"));
            if(s != null){
                String[] split = s.split(";");
                String host_dev = "192.168.0.114";
                send(host_dev,10452,split,100);
            }
        }
    }

    private static String readToMultipart(File file) throws IOException {
        String encoding = "UTF-8";
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    private static void send(String host, Integer port,String[] split,Integer millis){
        try {
            // 1.建立客户端socket连接，指定服务器位置及端口
            Socket clientSocket = new Socket(host, port);
            // 2.得到socket读写流
            OutputStream os = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            // 输入流
            InputStream is = clientSocket.getInputStream();

            // 3.利用流按照一定的操作，对socket进行读写操作
            for (String s1 : split) {
                //将十六进制的字符串转换成字节数组
                byte[] cmdInfor2 = hexStrToBinaryStr(s1);
                if(cmdInfor2 != null){
                    log.error("发送：" + s1);
                    Thread.sleep(millis);
                    os.write(cmdInfor2);
                    os.flush();
                }
            }

            clientSocket.shutdownOutput();
            // 4.关闭资源
            is.close();
            pw.close();
            os.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /** 将十六进制的字符串转换成字节数组 */
    public static byte[] hexStrToBinaryStr(String hexString) {
        if (StringUtils.isEmpty(hexString) || !hexString.contains("01")) {
            return null;
        }
        //
        // String removeChars = "receive protocol - [";
        // hexString = hexString.substring(hexString.indexOf(removeChars) + removeChars.length(), hexString.length());

        hexString = hexString.replaceAll(" ", "");
        hexString = hexString.replaceAll("\n", "");
        int len = hexString.length();
        int index = 0;

        byte[] bytes = new byte[len / 2];

        while (index < len) {

            String sub = hexString.substring(index, index + 2);

            bytes[index / 2] = (byte) Integer.parseInt(sub, 16);

            index += 2;
        }

        return bytes;
    }
}