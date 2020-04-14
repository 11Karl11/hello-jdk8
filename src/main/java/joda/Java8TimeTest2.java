package joda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author karl xie
 * Created on 2020-04-12 10:49
 */
public class Java8TimeTest2 {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        LocalDate localDate1 = localDate.plus(2, ChronoUnit.WEEKS);
        System.out.println(localDate1);

        System.out.println("--------------------");


        LocalDate localDate2 = localDate.minus(2, ChronoUnit.MONTHS);
        System.out.println(localDate2);

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        System.out.println("-------------");


        LocalDate localDate3 = LocalDate.now();
        LocalDate localDate4 = LocalDate.of(2017, 3, 19);
        System.out.println(localDate3.isAfter(localDate4));
        System.out.println(localDate3.isBefore(localDate4));
        System.out.println(localDate3.equals(localDate4));
        System.out.println("--------------------");


        Set<String> set = ZoneId.getAvailableZoneIds();
        Set<String> treeSet = new TreeSet<String>() {
            {
                addAll(set);
            }
        };
       // treeSet.stream().forEach(System.out::println);

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);

        YearMonth yearMonth=YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.isLeapYear());

        System.out.println("--------------------------");
        YearMonth yearMonth1 = YearMonth.of(2016, 2);
        System.out.println(yearMonth1);
        System.out.println(yearMonth1.lengthOfMonth());
        System.out.println(yearMonth1.lengthOfYear());
        System.out.println(yearMonth1.isLeapYear());


        LocalDate localDate6 = LocalDate.now();
        LocalDate localDate5 = LocalDate.of(2020, 3, 15);
        Period period = Period.between(localDate5, localDate6);
        System.out.println(period.getMonths());
        System.out.println(period.getDays());


        System.out.println("-----------------");

        System.out.println(Instant.now());
    }
}