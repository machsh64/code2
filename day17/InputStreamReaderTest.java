package day17;

import org.junit.Test;

import java.io.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-04 18:01
 * @description: 处理流之二：转换流的使用
 * 1，转换流：是属于字符流
 * InputStreamReader ： 将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter ： 将一个字符的输出流转换为字节的输出流
 * 2，作用：提供字节流于字符流之间的转换
 * <p>
 * 3，解码：字节，字节数组 ----> 字符数组，字符串
 * 编码：字符数组，字符串 ----> 字节，字节数组
 * <p>
 * 4，字符集
 **/
public class InputStreamReaderTest {
    //综合使用InputStreamReader 和 OutputStreamWriter
    @Test
    public void testIOSWR() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try{
            //1，读取文件
            fis = new FileInputStream(new File("day17\\IOFile\\dbcp.txt"));
            fos = new FileOutputStream(new File("day17\\IOFile\\dbcp_gbk.txt"));
            isr = new InputStreamReader(fis,"UTF-8");
            osw = new OutputStreamWriter(fos,"GBK");

            //2，读写过程
            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //3，资源关闭
                if (isr != null)
                    isr.close();
                if (osw != null)
                    osw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //InputStreamReader的使用
    @Test
    public void testISReader() {
        FileInputStream fis = null;
        InputStreamReader isr = null;

        try{
            fis = new FileInputStream(new File("day17\\IOFile\\dbcp.txt"));
            //    InputStreamReader isr = new InputStreamReader(fis);  //使用系统默认的编码形式解码
            //参数2 指明了字符集  具体使用那个字符集，取决于文件保存时使用的字符集
            isr = new InputStreamReader(fis, "UTF-8");  //使用文件保存时的编码形式解码

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(isr != null)
                isr.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
