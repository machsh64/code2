package day17;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-03 18:08
 * @description:
 *
 *    测试FileInputStream 和 FileOutputStream 的使用
 *
 *    结论：
 *    1，对于文本文件(.txt .java .c .cpp)，使用字符流处理
 *    2，对于非文本文件(.jpg .mp3 .mp4 .avi .ppt ...)，使用字节流处理
 **/
public class FileInputOutputStreamTest {

    @Test
    public void testFileInputStream() {
        File file1 = null;
        FileInputStream fis = null;
        try{
            //1，造文件
            file1 = new File("day17\\IOFile","hello.txt");

            //2，造流
            fis = new FileInputStream(file1);

            //3，读数据
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                    String str = new String(buffer,0,len);
                    System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //4，关闭资源
                if (fis != null)
                    fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    //FileInputStream / FileOutputStream对图片的复制测试
    @Test
    public void testFileReaderFileWriter5() {
        File file1 = null;
        File file2 = null;
        //  FileReader fr = null;
        //  FileWriter fw = null;
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try{
            //1，创建File类的对象，指明读入和写出的文件
            file1 = new File("D:\\machs\\Pictures\\三星多屏联动\\崩坏3-空之律者-泉之精灵_&_e34e80bf-2586-4f29-85de-0cd62317203b.jpg");
            file2 = new File("day17\\IOFIle","pictureTest.jpg");
            //2，创建输入和输出流的对象
            // fr = new FileReader(file1);
            // fw = new FileWriter(file2,false);
            fr = new FileInputStream(file1);
            fw = new FileOutputStream(file2,false);
            //3，数据的读入和写出操作  复制的过程
            byte[] cr = new byte[5];
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


    @Test
    public void test5() {
        File file1 = null;
        try{
            //1，File类的实例化
            file1 = new File("D:\\machs\\Pictures");
            JpgFinder(file1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void JpgFinder(File file){
        File[] list = file.listFiles();
        for (File file1 : list) {
            if (file1.getName().endsWith(".jpg")){
                System.out.println(file1.getAbsolutePath());
            }else if (file1.isDirectory()){
                JpgFinder(file1);
            }
        }
    }
}
