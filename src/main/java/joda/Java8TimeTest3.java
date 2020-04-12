package joda;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author karl xie
 * Created on 2020-04-12 11:12
 */
public class Java8TimeTest3 {
    public static void main(String[] args) {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println("Date = " + date);
        System.out.println("LocalDateTime = " + localDateTime);


        System.out.println("---------------------");


        ZoneId zoneId1 = ZoneId.systemDefault();
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime1.atZone(zoneId1);

        Date date1 = Date.from(zdt.toInstant());

        System.out.println("LocalDateTime = " + localDateTime1);
        System.out.println("Date = " + date1);
    }


}