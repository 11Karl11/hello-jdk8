package hello.demo;

/**
 * @author karl xie
 * Created on 2020-05-21 19:33
 */
public class IntegerTest1 {

    public static void main(String[] args) {
        Integer a=100;
        Integer b=100;
        Integer c=3000;
        Integer d=3000;
        System.out.println(a==b);
        System.out.println(c==3000);
        System.out.println(c==d);
        System.out.println(c.equals(d));
    }
}