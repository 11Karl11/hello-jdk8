package hello.advance.pattern.chain.second;

/**
 * @author karl xie
 * Created on 2021-01-05 21:22
 */
public class InfoLogger extends AbstractLogger{


    public InfoLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("InfoLoger Console::Logger: " + message);
    }

}