package day07;

import org.junit.Test;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-22 17:49
 * @description:
 **/
public class IDEADebug {
    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());  //4
        System.out.println(sb);  //null

      /*  StringBuffer sb1 = new StringBuffer(str);  //java.lang.NullPointerException   在源码中有str.length() 则报出空指针异常
        System.out.println(sb1);*/
    }
}
