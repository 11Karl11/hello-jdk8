package hello.genericity.other2;

import java.util.ArrayList;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(new A());
        list.add(new B());
        Object object = list.get(0);
        System.out.println(object.getClass());
    }

}