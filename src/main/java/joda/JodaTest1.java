package joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * @author karl xie
 * Created on 2020-04-12 09:56
 */
public class JodaTest1 {
    public static void main(String[] args) {

        DateTime today = new DateTime();
        DateTime tomorrow=today.plusDays(1);
        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));
        System.out.println("=================");
        DateTime d1=today.withDayOfMonth(1);
        System.out.println(d1.toString("yyyy-MM-dd"));
        System.out.println("-----------------");
        LocalDate localDate=new LocalDate();
        System.out.println(localDate);
        localDate=localDate.plusMonths(3).dayOfMonth().withMinimumValue();
        System.out.println(localDate);
        System.out.println("--------");

        //计算两年前第三月最后一天的日期
        DateTime dateTime=new DateTime();
        DateTime dateTime2=dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMinimumValue();
        System.out.println(dateTime2.toString("yyyy-MM-dd"));

    }
}