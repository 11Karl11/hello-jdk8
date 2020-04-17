package hello.joda;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author karl xie
 * Created on 2020-04-13 17:31
 */
public class java8Test4 {
    public static void main(String[] args) {
        LocalDate firstday = LocalDate.of(2020, 3, 1);
        LocalDate lastDay = firstday.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月的第一天" + firstday);
        System.out.println("本月的最后一天" + lastDay);
    }
}