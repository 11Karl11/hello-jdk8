package hello.advance.pattern.builder.first;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args){
        MyBuilder myBuilder = new MyBuilder();
        System.out.println(myBuilder);

        myBuilder.withName("Kerwin").withSex("男").withYear("1996");
        System.out.println(myBuilder);
    }
}