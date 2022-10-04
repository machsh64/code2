package day17;

import org.junit.Test;

import java.io.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-04 12:33
 * @description:
 *   处理流之一：缓冲流的使用
 *   
 *     1，缓冲流
 *     BufferedInputStream
 *     BufferedOutputStream
 *     BufferedReader
 *     BufferedWriter
 *     
 *     2，作用：提供流的读取，写入的速度
 *        提高读写速度的原因：内部提供了一个缓冲区
 **/
public class BufferedIOTest {
    /**
     * 实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest1() {
        File file1 = null;
        File file2 = null;
        FileInputStream fis= null;
        FileOutputStream fos= null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            //1，造文件
            file1 = new File("D:\\machs\\Pictures\\三星多屏联动\\崩坏3-空之律者-泉之精灵_&_e34e80bf-2586-4f29-85de-0cd62317203b.jpg");
            file2 = new File("day17\\IOFile\\PictureTest2.jpg");
            //2，造流
            //2.1 造节点流
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3，复制的细节：读入，写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //4，资源关流
                //要求，先关外层的流，在关内层的流
                if (bis != null)
                    bis.close();
                if(bos != null)
                    bos.close();
                //说明：关闭外层流的同时，内层流也会自动的关闭，所以内层流可以不手动的关闭
                if(fis != null)
                    fis.close();
                if(fos != null)
                    fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     *  实现文件复制的方法  使用BufferedIOStream
     */
    public static void copyFileWithBuffered(String srcPath,String destPath) {
        File file1 = null;
        File file2 = null;
        FileInputStream fis= null;
        FileOutputStream fos= null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            //1，造文件
            file1 = new File(srcPath);
            file2 = new File(destPath);
            //2，造流
            //2.1 造节点流
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3，
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //4，资源关流
                //要求，先关外层的流，在关内层的流
                if (bis != null)
                    bis.close();
                if(bos != null)
                    bos.close();
                //说明：关闭外层流的同时，内层流也会自动的关闭，所以内层流可以不手动的关闭
                if(fis != null)
                    fis.close();
                if(fos != null)
                    fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     *  实现文件复制的方法  使用FileIOStream
     */
    public static void copyFileWithFileStream(String srcPath,String destPath){
        File file1 = null;
        File file2 = null;
        //  FileReader fr = null;
        //  FileWriter fw = null;
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try{
            //1，创建File类的对象，指明读入和写出的文件
            file1 = new File(srcPath);
            file2 = new File(destPath);
            //2，创建输入和输出流的对象
            fr = new FileInputStream(file1);
            fw = new FileOutputStream(file2,false);
            //3，数据的读入和写出操作  复制的过程
            byte[] cr = new byte[10];
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
    public void test() {
        long start = System.currentTimeMillis();
        copyFileWithBuffered("D:\\machs\\Pictures\\三星多屏联动\\崩坏3-空之律者-泉之精灵_&_e34e80bf-2586-4f29-85de-0cd62317203b.jpg",
                "day17\\IOFile\\PictureTest.jpg");
        long end = System.currentTimeMillis();
        System.out.println("复制操作1花费的时间" + (end - start));  // 5  实现文件复制的方法  使用FileIOStream

        long start1 = System.currentTimeMillis();
        copyFileWithFileStream("D:\\machs\\Pictures\\三星多屏联动\\崩坏3-空之律者-泉之精灵_&_e34e80bf-2586-4f29-85de-0cd62317203b.jpg",
                "day17\\IOFile\\PictureTest.jpg");
        long end1 = System.currentTimeMillis();

        System.out.println("复制操作2花费的时间" + (end1 - start1));   // 108 实现文件复制的方法  使用FileIOStream
    }
}
