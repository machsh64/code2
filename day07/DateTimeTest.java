package day07;

import org.junit.Test;

import java.util.Date;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-22 16:49
 * @description: JDK 8之前日期和时间的API测试
 **/
public class DateTimeTest {
    //1，System类中的currentTimeMillis();
    @Test
    public void test() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }

    /**
     * java.util.Date类
     * /----java.sql.Date类
     *
     * 1，两个构造器的使用
     *   构造器一：Date()  创建一个对应当前时间的Date对象
     *   构造器二：Date(long Millis)  创建毫秒数的Date对象
     *
     * 2，两个方法的使用
     *   >toString();  显示当前的年,月,日,时,分,秒
     *   >getTime();    获取当前Date对象对应的毫秒数  (时间戳)
     *
     * 3，java.sql.Date 对应着数据库中的日期类型的变量
     *   >如何实例化
     *   >如何将util.Date对昂转换为java.sql.Date对象
     */
    @Test
    public void test2() {
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());  //Thu Sep 22 16:58:44 CST 2022
        java.sql.Date date= new java.sql.Date(date1.getTime());
        System.out.println(date);  //2022-09-24

        System.out.println(date1.getTime());  //1663837124550

        //构造器二：创建毫秒数的Date对象
        Date date2 = new Date(1550306204104L);
        System.out.println(date2.toString());  //Sat Feb 16 16:36:44 CST 2019

        //创建java.sql.Date对象  用于sql表中的日期
        java.sql.Date date3 = new java.sql.Date(35235325345L);
        System.out.println(date3.toString());  //1971-02-13

        //如何将util.Date对昂转换为java.sql.Date对象
        //情况一：
     /*   Date date4 = new java.sql.Date(2343242424L);
        java.sql.Date date5 = (java.sql.Date) date4;*/
        //情况二：
        Date date6 = new Date(1994343242424L);
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        System.out.println(date7.toString());
    }
}
