package hello.advance.pattern.chain.second;

/**
 * @author karl xie
 */
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ErrorLoger Console::Logger: " + message);
    }
}