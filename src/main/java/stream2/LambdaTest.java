package stream2;

/**
 * @Description TODO
 * @Date 2020/4/8 22:52
 * @Created karl xie
 */
public class LambdaTest {

    //stream2.LambdaTest@1dc727cc(没有开辟作用域)
    Runnable r1=()-> System.out.println(this);
    Runnable r2=new Runnable() {
        @Override
        public void run() {
            //stream2.LambdaTest$1@7e611cce(开辟了新的空间)
            System.out.println(this);
        }
    };
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        Thread t1 = new Thread(lambdaTest.r1);
        t1.start();
        System.out.println("------------");
        Thread t2 = new Thread(lambdaTest.r2);
        t2.start();
    }
}
