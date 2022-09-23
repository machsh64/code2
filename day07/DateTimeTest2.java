package day07;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-23 16:03
 * @description:  Calender 日历类（抽象类）的使用
 **/
public class DateTimeTest2 {
    //1，实例化
    //方式一：创建其子类(GregorianCalendar)的对象
    //方式二：调用其静态方法getInstance()
    @Test
    public void testCalender(){
        Calendar calendar = Calendar.getInstance();
        /*System.out.println(calendar.getClass());*/

    //2，常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);  //当前月的第几天
        int days1 = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(days1);  //当前周的第几天
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,2);  //修改本月第几天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);   //修改后的月的第几天
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,8);  //给当前月天数加8天，若数值为负数，则为减几天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //getTime()
        Date date = calendar.getTime();  //获取到的是修改过的日期
        System.out.println(date);
        //setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);   //将当前月的第几天修改为了从Date获取来的天数
        System.out.println(days);
    }
}
