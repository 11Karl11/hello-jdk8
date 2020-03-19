package hello.jdk8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description TODO
 * @Date 2020/3/19 23:23
 * @Created karl xie
 */
public class PredicateTest2 {
    public static void main(String[] args) {
        ArrayList<Integer> list =
                Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest2 test = new PredicateTest2();
//        test.conditionFilter(list, item -> item % 2 == 0);
//        System.out.println("==============");
//        test.conditionFilter(list, item -> item % 2 != 0);
//        System.out.println("===============");
//        test.conditionFilter(list, item -> item > 5);
//        System.out.println("===========");
//        test.conditionFilter(list, item -> item < 3);
//        System.out.println("==========");
//        test.conditionFilter(list, item -> true);
//        System.out.println("===========");
//        test.conditionFilter(list, item -> false);
//        test.conditionFilter2(list, integer -> integer > 5,
//                integer -> integer % 2 == 0);
        System.out.println(test.isEqual(new Date()).test(new Date()));



    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }

    }

    public void conditionFilter2(List<Integer> list,
                                 Predicate<Integer> predicate1,
                                 Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate1.and(predicate2).negate().test(integer)) {
                System.out.println(integer);
            }
        }

    }

    public Predicate<Date> isEqual(Object object){
        return Predicate.isEqual(object);

    }
}
