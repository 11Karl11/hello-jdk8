package hello.demo;

/**
 * @author karl xie
 */
public class BasePro extends Base{

    @Override protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception {
        BasePro basePro = new BasePro();
        System.out.println(basePro.clone().getClass()); // 输出 class com.example.demo.Base
        System.out.println(basePro.getClass()); // 输出 class com.example.demo.BasePro
    }
}