package hello.jdk8;

import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.EAN;

import java.util.List;
import java.util.function.Consumer;

/**
 * @Description TODO
 * @Date 2020/3/15 14:22
 * @Created karl xie
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list= Lists.newArrayList(1,2,3,4,5,6,7,8);
//        for (int i=0;i<list.size();++i){
//            System.out.println(list.get(i));
//        }
//        System.out.println("----------------------");
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
//        System.out.println("=------------------");
//        list.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
        list.forEach(t-> System.out.println(t));
        System.out.println("-------------------");
        // method reference
        list.forEach(System.out :: println);
     }

}
