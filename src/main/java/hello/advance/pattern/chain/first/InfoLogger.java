package hello.advance.pattern.chain.first;



/**
 * @author karl xie
 * Created on 2021-01-05 21:10
 */
public class InfoLogger implements LoggerInterface {

    @Override
    public void write(int level, String message) {
        if (level == LoggerEnums.INFO.getValue()) {
            System.out.println("InfoLoger Console::Logger: " + message);
        } else {
            this.setNextLogger(new DebugLogger());
            this.getNextLogger().write(level, message);
        }
    }

    private LoggerInterface loggerInterface;

    @Override
    public void setNextLogger(LoggerInterface nextLogger) {
        loggerInterface = nextLogger;
    }

    @Override
    public LoggerInterface getNextLogger() {
        return loggerInterface;
    }

}