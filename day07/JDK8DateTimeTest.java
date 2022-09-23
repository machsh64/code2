package day07;

import org.junit.Test;

import java.time.*;
import java.util.Date;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-23 16:53
 * @description:  JDK8 中日期时间API的测试
 **/
public class JDK8DateTimeTest {

    @Test
    public void test() {
        Date date1 = new Date(2020, 9, 8); //已过时
        System.out.println(date1);   //Fri Oct 08 00:00:00 CST 3920  具有偏移量
    }

    /**
    *  LocalDate, LocalTime, LocalDateTime 的使用
     *  说明：LocalDateTime 相较于 LocalDate, LocalTime 使用频率更高
     */
    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);  //2022-09-23
        System.out.println(localTime);  //17:10:54.748
        System.out.println(localDateTime);  //2022-09-23T17:10:54.748

        //of(): 设置指定的年月日时分秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 5, 13, 14);
        System.out.println(localDateTime1);  //2020-10-05T13:14

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());  //23
        System.out.println(localDateTime.getDayOfWeek());  //FRIDAY
        System.out.println(localDateTime.getMonth());  //SEPTEMBER
        System.out.println(localDateTime.getMonthValue());  //9
        System.out.println(localDateTime.getMinute());  //31

        //Local体现的不可变性
        //withXxx()：设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(2);
        System.out.println(localDate);  //2022-09-23  原来的localDate并未发生改变
        System.out.println(localDate1);  //2022-09-02  返回值发生了改变

        LocalDateTime localDateTime2 = localDateTime.withHour(2);
        System.out.println(localDateTime);  //2022-09-23T17:31:21.868
        System.out.println(localDateTime2);  //2022-09-23T02:31:21.868

        //  不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(2);
        System.out.println(localDateTime);  //2022-09-23T17:35:23.771  原有的localDateTime不发生改变
        System.out.println(localDateTime3);  //2022-11-23T17:35:23.771  在现有月份上加了2个月赋值给新的时间

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);  //2022-09-23T17:37:24.299  原有日期不发生改变
        System.out.println(localDateTime4);  //2022-09-17T17:37:24.299  在现有日期上减了6天
    }

    /**
    * Instant的使用
     * 类似于java.util.Date类
     */
    @Test
    public void test2() {
        //now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);  //2022-09-23T09:54:43.055Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);  //2022-09-23T17:55:52.997+08:00

        //toEpochMilli()：获取子1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);  //1663927078437

        //
        Instant instant1 = Instant.ofEpochMilli(1663927078437L);
        System.out.println(instant1);  //2022-09-23T09:57:58.437Z
    }
}
