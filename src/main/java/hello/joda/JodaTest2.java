package hello.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * @author karl xie
 * Created on 2020-04-12 10:06
 */
public class JodaTest2 {


    //标准UTC时间:2014-11-04T09:22:54.876Z
    public static Date convertUTC2Date(String utcDate) {
        try {
            DateTime dateTime = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            return dateTime.toDate();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertDate2UTC(Date date) {
        DateTime dateTime = new DateTime(date, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static String convertDate2LocalByDateFormat(Date date, String format) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);
    }

    public static void main(String[] args) {
        System.out.println(JodaTest2.convertUTC2Date("2014-11-04T02:25:25.236Z"));
        System.out.println(JodaTest2.convertDate2UTC(new Date()));
        System.out.println(JodaTest2.convertDate2LocalByDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }


}