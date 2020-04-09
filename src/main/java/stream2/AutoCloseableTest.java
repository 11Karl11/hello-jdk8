package stream2;

/**
 * @Description TODO
 * @Date 2020/3/29 11:45
 * @Created karl xie
 */
public class AutoCloseableTest implements AutoCloseable {


    public void doSomething(){
        System.out.println("doSomething invoked");
    }


    @Override
    public void close() throws Exception {
        System.out.println("close invoked");

    }


    public static void main(String[] args) throws Exception {
        try(AutoCloseableTest autoCloseableTest = new AutoCloseableTest()){
            autoCloseableTest.doSomething();
        }


    }
}
