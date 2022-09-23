package day06;

import org.junit.Test;

import java.util.Date;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-22 15:38
 * @description: 关于StringBuffer和StringBuilder的使用
 **/
public class StringBufferBuilderTest {
    /**
     * String，StringBuffer，StringBuilder三者的异同
     * JDK1.0>  String：不可变的字符串序列，底层使用char[]存储
     * JDK1.0>  StringBuffer：可变的字符串序列  线程安全的，效率低     在多线程中使用   底层使用char[]存储
     * JDK1.5>  StringBuilder：可变的字符串序列  线程不安全的，效率高    在非多线程中使用提高效率   底层使用char[]存储
     *
     * 源码分析：
     * String str = new String();  //value = new char[0];
     * String str = new String("abc");  //value = new char[]{'a','b','c'};
     *
     * StringBuffer sb1 = new StringBuffer();  //char[] value = new char[16];  底层创建了一个长度是16的char型数组
     * System.out.println(sb1.length());   //0
     * sb1.append('a');  //value[0] = 'a';
     * sb1.append('b');  //value[1] = 'b';
     *
     * StringBuffer sb2 = new StringBuffer("abc");  //char[] value = new char[]{"abc".length + 'a','b','c'}
     *
     * 问题1：System.out.println(sb2.length());  //3
     * 问题2：扩容问题：如果要添加的数据底层添加不下了，那就需要扩容底层的数组
     *                默认情况下，扩容为原来容量的 2倍 + 2，同时将原有的数组复制到新的数组中
     *
     *        指导意义：开发之中建议使用StringBuffer(int capacity)或StringBuilder(int capacity);
     */

    @Test
    public void test() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');  //在String中该方法返回一个数组，原数组不变
        System.out.println(sb1); //mbc  //此处sb1变为mbc，验证StringBuffer是可变数组


        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());   //0
    }

    @Test
    public void test1() throws InterruptedException {

        long start = System.nanoTime();
       String str = "String";
       long end = System.nanoTime();
       System.out.println(str + " 的执行时间为 " + (end - start) + " ns");

        long start1 = System.nanoTime();
        StringBuffer str1 = new StringBuffer("String");
        long end1 = System.nanoTime();
        System.out.println(str1 + " 的执行时间为 " + (end1 - start1) + " ns");

        long start2 = System.nanoTime();
        StringBuilder str2 = new StringBuilder("String");
        long end2 = System.nanoTime();
        System.out.println(str2 + " 的执行时间为 " + (end2 - start2) + " ns");
    }
}
