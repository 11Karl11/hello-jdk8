package hello.advance.pattern.chain.first;

/**
 * @author karl xie
 * Created on 2021-01-05 21:11
 */
public class ErrorLogger implements LoggerInterface {

    @Override
    public void write(int level, String message) {
        System.out.println("ErrorLoger Console::Logger: " + message);
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