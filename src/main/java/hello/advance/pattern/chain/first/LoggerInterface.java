package hello.advance.pattern.chain.first;

/**
 * @author karl xie
 * Created on 2021-01-05 21:07
 */
public interface LoggerInterface {

    // 必须包含对象传递
    void setNextLogger(LoggerInterface nextLogger);

    LoggerInterface getNextLogger();

    // 抽象方法 -> 重写具体日志输出类型
    void write(int level, String message);
}
