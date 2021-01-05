package hello.advance.pattern.chain.first;

/**
 * @author karl xie
 * Created on 2021-01-05 21:11
 */
public class Test {
    public static void main(String[] args){
        LoggerInterface log = new InfoLogger();
        log.write(LoggerEnums.DEBUG.getValue(), "test the debug message");
    }

}