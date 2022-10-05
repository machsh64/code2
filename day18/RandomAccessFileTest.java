package day18;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-05 20:15
 * @description:
 *
 *   RandomAccessFile的使用
 *   1，RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 *   2，RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 *   3，如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建，如果
 *     写出到的文件存在，则会对原有文件内容进行覆盖，（默认情况下，从头开始进行覆盖）
 *
 *   4，可以通过相关的操作，实现RandomAccessFile插入操作的效果
 **/
public class RandomAccessFileTest {

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;

        try{
            raf1 = new RandomAccessFile(new File("day18\\IOFile\\PictureTest.jpg"),"r");
            raf2 = new RandomAccessFile(new File("day18\\IOFile\\PictureTest1.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (raf1 != null)
                    raf1.close();
                if (raf2 != null)
                    raf2.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf1 = null;

        try{
            raf1 = new RandomAccessFile(new File("day18\\IOFile\\hello.txt"),"rw");
            raf1.seek(3);  //将指针调到角标为3的位置
           // raf1.seek(raf1.length());  //将指针调到末尾的位置
      /*      raf1.write("xyz".getBytes());*/

            //保存指针3后面的数据到StringBuilder中
            byte[] buffer = new byte[20];
            int len;
            StringBuilder builder = new StringBuilder((int) new File("day18\\IOFile\\hello.txt").length());
            while ((len = raf1.read(buffer)) != -1){
                builder.append(new String(buffer,0,len));
            }

            raf1.write(builder.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (raf1 != null)
                    raf1.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
