package joda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

/**
 * @author karl xie
 * Created on 2020-04-12 10:20
 */
public class Java8TimeTest {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate.getYear()+","+localDate.getMonthValue()+","+localDate.getDayOfMonth());
        System.out.println("------------------------");

        LocalDate localDate2=LocalDate.of(2017,3,3);
        System.out.println(localDate2);
        System.out.println("-------------");


        LocalDate localDate3=LocalDate.of(2010,3,25);
        MonthDay monthDay=MonthDay.of(localDate3.getMonth(),localDate3.getDayOfMonth());
        MonthDay monthDay2=MonthDay.from(LocalDate.of(2011,3,25));
        if (monthDay.equals(monthDay2)){
            System.out.println("equals");
        }else {
            System.out.println("not equals");
        }

        System.out.println("------------");


        LocalTime time=LocalTime.now();
        System.out.println(time);

        LocalTime time1 = time.plusHours(3).plusMinutes(20);
        System.out.println(time1);

    }
}