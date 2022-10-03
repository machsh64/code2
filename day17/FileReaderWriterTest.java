package day17;

import org.junit.Test;

import java.io.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-03 16:09
 * @description:
 *
 *     一，流的分类：
 *      1，操作数据单位：字节流，字符流
 *      2，数据的流向：输入流，输出流
 *      3，流的角色：节点流，处理流
 *
 *     二：流的体系结构
 *      抽象基类         节点流（或文件流）         缓冲流（处理流的一种）
 *     InputStream      FileInputStream        BufferedInputStream
 *     OutputStream     FileOutputStream       BufferedOutputStream
 *     Reader           FileReader             BufferedReader
 *     Writer           FileWriter             BufferedWriter
 **/
public class FileReaderWriterTest {

    /**
     * 将IOFile下hello.txt文件内容读入程序中，并输出到控制台
     *
     * 说明点：
     *  1，read()的理解：返回读入的一个字符，如果达到文件末尾，则返回-1
     *  2，异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
     *  3，读入的文件一定要存在，否则就会报FileNotFoundException
     */
    @Test
    public void testFileReader1() {
        File file1 = null;
        FileReader fr = null;
       try{
           //1，实例化File类的对象，指明要操作的文件
           file1 = new File("day17\\IOFIle","hello.txt");
           System.out.println(file1.exists());
           System.out.println(file1.getAbsolutePath());
           //2，提供具体的流
           fr = new FileReader(file1);

           //3，数据的读入
           //read()：返回读入的一个字符。如果达到文件末尾，返回-1
           int data;
           while((data = fr.read()) != -1){
               System.out.print((char) data);
           }
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           try {
               if(fr != null)
                   //4，流的关闭操作
                   fr.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
    /**
     *  对read()操作升级：使用read的重载方法
     */
    @Test
    public void testFileReader2() {
        File file1 = null;
        FileReader fr = null;
        try{
            //1，File类的实例化
            file1 = new File("day17\\IOFIle","hello.txt");
            //2，FileReader流的实例化
            fr = new FileReader(file1);
            //3，读入的操作
            //read(char[] cr)：返回每次读入cr数组中的字符的个数，如果达到文件末尾，返回-1
            char[] cr = new char[5];
            int len;
            while ((len = fr.read(cr)) != -1){
                //正确写法
                 for (int i = 0;i < len;i++) {
                    System.out.print(cr[i]);   //HelloWorld123
                }
                //错误写法
               /* for (int i = 0;i < cr.length;i++) {
                    System.out.print(cr[i]);   //HelloWorld123ld
                }*/
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fr != null)
                //4，流资源的关闭
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  从内存中写出是数据到硬盘的文件里
     *
     *  说明：
     *   1，输出操作，对应的File可以不存在的，并不会报异常
     *   2，
     *       File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件
     *       File对应的硬盘中的文件如果存在：
     *              如果流使用的构造器是FileWriter(file, false)/FileWriter(file) ：对原有文件的覆盖
     *              如果流使用的构造器是FileWriter(file, true) ：则不会对原有文件覆盖，而是在原有文件增加
     */
    @Test
    public void testFileWriter3() {
        File file1 = null;
        FileWriter fw = null;

        try{
            //1，提供File类的对象，指明写出到的文件
            file1 = new File("day17\\IOFIle","hello.txt");
            //2，提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file1,true);
            //3，写出的操作
            fw.write("写入的操作测试");
            fw.write("，测试2");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fw != null)
                    //4，流资源的关闭
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //使用FileReader / FileWriter 对文本文件进行复制
    @Test
    public void testFileReaderFileWriter4() {
        File file1 = null;
        File file2 = null;
        FileReader fr = null;
        FileWriter fw = null;

        try{
            //1，创建File类的对象，指明读入和写出的文件
            file1 = new File("day17\\IOFIle","hello.txt");
            file2 = new File("day17\\IOFIle","hello2.txt");
            //2，创建输入和输出流的对象
            fr = new FileReader(file1);
            fw = new FileWriter(file2,false);
            //3，数据的读入和写出操作
            char[] cr = new char[5];
            int len;
            while ((len = fr.read(cr)) != -1){
                    //每次写出len个字符
                    fw.write(cr,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                //4，关闭流资源
                if (fr != null)
                fr.close();
                if (fw != null)
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
