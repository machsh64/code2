package day07;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-23 11:54
 * @description: JDK 8之前的日期时间的API测试
 * 1，System类中currentTimeMillis();
 * 2，java.util.Date和子类java.sql.Date
 * <p>
 * 3，SimpleDateFormat
 * 4,Calender
 **/
public class DateTimeTest1 {

    /**
     * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     * <p>
     * 1 两个操作
     * 1.1 格式化：日期 --- >字符串
     * 1.2 解析：格式化的逆过程，字符串 ---> 日期
     * <p>
     * 2.SimpleDateFormat的实例化
     */
    @Test
    public void test() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println(date); //Fri Sep 23 12:06:05 CST 2022

        String format = sdf.format(date);
        System.out.println(format);  //22-9-23 下午12:06

        //解析：格式化的逆过程 ，字符串 ---> 日期
        /* String str = "2019-08-09";*/  //需要有特定格式
        String str = "19-08-09 下午13:33";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //*******按照指定的方式格式化和解析：调用带参的构造器********
        /*SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy-MMMMM-dd GGG hh::mm aaa");*/
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);  //2022-09-23 02:55:22
        //解析：要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        //否则：抛异常
        Date date2 = sdf1.parse("2011-02-23 02:55:22");
        System.out.println(date2);
    }

    /**
     * 练习一：字符串"2020-09-08"转换为java.sql.Date
     */
    @Test
    public void test2() throws ParseException {
        String str = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        /* System.out.println(date);*/
        java.sql.Date jtm = new java.sql.Date(date.getTime());
        System.out.println(jtm);  //2020-09-08
    }

    /**
     * 练习二：三天打鱼两天晒网，从1990-01-01 开始，xxxx-xx-xx 是打鱼还是在筛网
     */
    @Test
    public void test3() throws ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("1990-01-01");
        long beg = date.getTime();

        System.out.println("输入天数（xxxx-xx-xx）：");
        String str = scan.next();
        Date date1 = sdf.parse("1990-01-011");
        long end = date1.getTime();

        long set = end - beg;
        if (0 < set % (60 * 60 * 24 * 5) && set % (60 * 60 * 24 * 5) < 3){
            System.out.println("在打鱼");
        }else {
            System.out.println("在筛网");
        }

    }
}
