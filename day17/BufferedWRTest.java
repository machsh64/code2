package day17;

import org.junit.Test;

import java.io.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-04 13:16
 * @description:
 *   使用BufferedReader 和 BufferedWriter实现文本文件的复制
 **/
public class BufferedWRTest {

    /**
     *   实现文本文件复制  使用BufferedWR
     */
    @Test
    public void BufferedWRTest1() {
        File file1 = null;
        File file2 = null;
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader bfr = null;
        BufferedWriter bfw = null;

        try{
            //1，造文件
            file1 = new File("day17\\IOFile","dbcp.txt");
            file2 = new File("day17\\IOFile","dbcp1.txt");
            //2，造流
            //2.1 造节点流
            fr = new FileReader(file1);
            fw = new FileWriter(file2);
            //2.2 造缓冲流
            bfr = new BufferedReader(fr);
            bfw = new BufferedWriter(fw);
            //3，复制的细节 读取，写入
            //方式一：使用char[]数组
          /*  char[] buffer = new char[1024];
            int len;
            while ((len = bfr.read(buffer)) != -1){
                bfw.write(buffer,0,len);
            }*/
            //方式二：使用String
            String data;
            while ((data = bfr.readLine()) != null){
                //方法一：data中并不包含换行，则将换行包含在写入中
                bfw.write(data + "\n");
                //方法二：使用bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //4，关闭资源
                if(bfr != null)
                bfr.close();
                if(bfw != null)
                bfw.close();
                //说明：关闭外层流的同时，内层流也会自动的关闭，所以内层流可以不手动的关闭
                if(fr != null)
                fr.close();
                if(fw != null)
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     *   实现文本文件复制的方法  使用BufferedWR
     */
    public static void copyTXTWithBufferedWR(String srcPath,String destPath){
        BufferedReader bfr = null;
        BufferedWriter bfw = null;

        try{
            //2.2 造缓冲流
            bfr = new BufferedReader(new FileReader(new File(srcPath)));
            bfw = new BufferedWriter(new FileWriter(new File(destPath)));
            //3，复制的细节 读取，写入
            String data;
            while ((data = bfr.readLine()) != null){
                //方法一：data中并不包含换行，则将换行包含在写入中
                bfw.write(data + "\n");
                //方法二：使用bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //4，关闭资源
                if(bfr != null)
                    bfr.close();
                if(bfw != null)
                    bfw.close();
                //说明：关闭外层流的同时，内层流也会自动的关闭，所以内层流可以不手动的关闭
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     *   实现文本文件复制的方法  使用FileWR
     */
    public static void copyTXTWithFileWR(String srcPath,String destPath){
        File file1 = null;
        File file2 = null;
        FileReader fr = null;
        FileWriter fw = null;
        try{
            //1，造文件
            file1 = new File(srcPath);
            file2 = new File(destPath);
            //2，造流
            //2.1 造节点流
            fr = new FileReader(file1);
            fw = new FileWriter(file2);
            //3，复制的细节 读取，写入
            char[] buffer = new char[1024];
            int len;
            while ((len = fr.read(buffer)) != -1){
                fw.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //4，关闭资源
                if(fr != null)
                    fr.close();
                if(fw != null)
                    fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //测试两种方法复制文本文件的时间效率
    // ！注 ：此处缓冲流比普通复制操作时间长的原因在于：
    //    因为复制的文本字符数量太少，缓冲流再刷新时花费的时间多，若复制文本数量级多，则缓冲流花费时间少
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        copyTXTWithBufferedWR("day17\\IOFile\\dbcp.txt",
                "day17\\IOFile\\dbcp1.txt");
        long end = System.currentTimeMillis();
        System.out.println("复制操作1花费的时间" + (end - start));  // 5  实现文本文件复制的方法  使用BufferedWR

        long start1 = System.currentTimeMillis();
        copyTXTWithFileWR("day17\\IOFile\\dbcp.txt",
                "day17\\IOFile\\dbcp1.txt");
        long end1 = System.currentTimeMillis();
        System.out.println("复制操作2花费的时间" + (end1 - start1));   // 108 实现文本文件复制的方法  使用FileWR

    }
}
