package hello.advance.pattern.chain.second;

/**
 * @author karl xie
 */
public class DebugLogger  extends AbstractLogger{

    public DebugLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("DebugLoger Console::Logger: " + message);
    }

}