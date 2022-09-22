package day05;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-22 14:52
 * @description:  字符串的编码与解码
 **/
public class StringTest1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] sPasskey = {27, 36, 66, 77, 123, 54, 98, 62, 79, 27, 40, 66, 115, 117, 112, 101, 114, 32, 104, 101, 97, 118, 101, 114};
        //对str进行编码，charsetName需要为现有的编码规则
       /*String str = "李金章super heaver";
        byte[] sPasskey = str.getBytes("ISO-2022-JP-2");
        System.out.println(Arrays.toString(sPasskey));*/

        //对sPassKey进行解码，charsetName需要为sPassKey的编码规则
        String str1 = new String(sPasskey,"ISO-2022-JP");
        System.out.println(str1);
    }
}
