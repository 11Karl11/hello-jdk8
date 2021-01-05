package hello.advance.pattern.chain.second;

/**
 * @author karl xie
 * Created on 2021-01-05 21:20
 */
public abstract class AbstractLogger {

    // 责任级别
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    // 当前级别
    int level;

    //责任链中的下一个元素
    AbstractLogger nextLogger;
    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    // 记录日志
    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }

        if(nextLogger != null){
            nextLogger.logMessage(level, message);
        }
    }

    // 抽象方法 -> 重写具体日志输出类型
    abstract protected void write(String message);

}