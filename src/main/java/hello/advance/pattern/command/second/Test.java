package hello.advance.pattern.command.second;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 *命令模式的设计思路：
 * Command 声明命令的接口
 * ConcreteCommand 具体的动作 | 命令
 * Client 客户端请求
 * Invoker 绑定命令与接收者
 * Receiver 接收者 知道如何实施与执行一个请求相关的操作，任何类都可以是接收者
 *
 * 简易Jedis代码, 利用栈存储命令(可根据需求更改数据结构)
 * @author karl xie
 * Created on 2020-12-16 18:02
 */
public class Test {

    public static void main(String[] args) throws IOException {
        // 初始化Socket流
        Socket socket = new Socket("192.168.136.129", 6379);
        OutputStream write = socket.getOutputStream();
        InputStream read = socket.getInputStream();

        Invoker invoker = new Invoker();

        // 初始化Get | Set任务执行者
        GetReceiver getReceiver = new GetReceiver(write, read);
        SetReceiver setReceiver = new SetReceiver(write, read);

        // 测试get命令
        invoker.addCommand(new GetCommand(getReceiver, "key"));

        // 测试set命令
        invoker.addCommand(new SetCommand(setReceiver, "key xixixi"));

        // 测试get命令
        invoker.addCommand(new GetCommand(getReceiver, "key"));

        // 测试get命令
        invoker.addCommand(new GetCommand(getReceiver, "key"));

        // 测试撤销上一个命令 -> 输出四次则测试失败，三次则成功
        invoker.undoCommand();
        invoker.execute();
    }
}