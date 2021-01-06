package hello.advance.pattern.adapter.second;

/**
 * @author karl xie
 */
public class Test {

    /***
     * 接口适配器, 对接口进行适配器策略，可以大大减少需要重写的方法（需要用什么就重写什么）
     *
     * JDK中的接口适配器Demo:
     */
    public static void main(String[] args){

        new InterfaceAdapter(){}.a();

        new InterfaceAdapter(){
            @Override
            public void b() {
                System.out.println("I am b.");
            }
        }.b();
    }
}