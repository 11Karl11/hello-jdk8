package hello.advance.pattern.chain.first;

/**
 * @author karl xie
 * Created on 2021-01-05 21:10
 */
public class DebugLogger implements LoggerInterface{

    @Override
    public void write(int level, String message) {
        if (level == LoggerEnums.DEBUG.getValue()) {
            System.out.println("DebugLoger Console::Logger: " + message);
        } else {
            this.setNextLogger(new ErrorLogger());
            this.getNextLogger().write(level, message);
        }
    }

    private LoggerInterface loggerInterface;

    @Override
    public void setNextLogger(LoggerInterface nextLogger) {
        this.loggerInterface = nextLogger;
    }

    @Override
    public LoggerInterface getNextLogger() {
        return loggerInterface;
    }

}