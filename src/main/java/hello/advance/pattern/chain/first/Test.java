package hello.advance.pattern.chain.first;

/**
 * @author karl xie
 */
public class Test {
    public static void main(String[] args){
        LoggerInterface log = new InfoLogger();
        log.write(LoggerEnums.ERROR.getValue(), "test the debug message");
    }

}