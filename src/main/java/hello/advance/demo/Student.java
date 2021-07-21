package hello.advance.demo;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author karl xie
 */
public class Student extends Person{

     public void sum(Integer a,Integer b){
         System.out.println(a+b);
     }

    public void sum(Double a,Double b){
        System.out.println(a+b);
    }

    public static void main(String[] args) throws Exception {
        Class<?> student = Class.forName("hello.advance.demo.Student");
        Method[] methods = student.getMethods();
        Method sum = student.getMethod("sum",Integer.class,Integer.class);
        Object invoke = sum.invoke(student.newInstance(), 1, 1);
    }

}