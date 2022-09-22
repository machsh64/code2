package day05;

import org.junit.Test;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-21 16:54
 * @description:   String的使用
 **/
public class StringTest {
    /**
      String：字符串使用一对""引起来表示
      1，String声明为final的，不可被继承
      2，String实现了Serializable接口：表示字符串是支持序列化的
               实现了Comparable接口：表示String可以比较大小
      3，String内部定义了final char[] value用于存储字符串数据
      4，String：代表不可变的字符序列。简称：不可变性
           体现：1，当对字符串重新赋值时，需要重新指定内存区域赋值，而不能使用原有value进行赋值，因为字符串为final，不可被重写
                2，当对现有的字符串进行加减操作时，仍要重新指定内存区域进行赋值
                3，当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值
      5，通过字面量的方式给一个字符串赋值，此时字符串值声明在字符串常量池中。
      6，字符串常量池中是不会存储同样的两个字符串的
     */
    @Test
    public void test1(){
        String s1 = "abc";   //字面量
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1 == s2);   //比较s1与s2的地址值

        System.out.println(s1);  //hello
        System.out.println(s2);  //abc

        System.out.println("*******************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);  //abcdef
        System.out.println(s2);  //abc

        System.out.println("*******************");

        String s4 = "abc";
        String s5 = s4.replace("a","m");
        System.out.println(s4);  //abc
        System.out.println(s5);  //mbc
    }

    /**
      String的实例化方式：
        方式一：通过字面量定义的方法
        方式二：通过new + 构造器的方法
    */

    @Test
    public void test2(){
        //通过字面量定义的方法：此时s1和s2的数据javaEE声明在方法区的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方法：此时s3和s4的数据javaEE是在堆空间中开辟空间以后对应的
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);  //true
        System.out.println(s3 == s4);  //false

    }
}
