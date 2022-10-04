package day17.exer;

import java.io.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-04 14:02
 * @description:
 *
 * 1. 分别使用节点流：FileInputStream、FileOutputStream和缓冲流：
 *    BufferedInputStream、BufferedOutputStream实现文本文件/图片/视频文件的
 *    复制。并比较二者在数据复制方面的效率
 * 2. 实现图片加密操作。
 *    提示：
 * 3. 获取文本上每个字符出现的次数
 *    提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据
 *    写入文件
 **/
public class BufferedExec1 {

    /**
     * 1.分别使用节点流：FileInputStream、FileOutputStream和缓冲流：
     *   BufferedInputStream、BufferedOutputStream实现文本文件/图片/视频文件的
     *   复制。并比较二者在数据复制方面的效率
    */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        copyFileWithFileIOStream("day17\\IOFile\\PictureTest.jpg","day17\\IOFile\\PictureTest1.jpg");
        long end = System.currentTimeMillis();
        System.out.println("使用FileIOStream复制非文本文件的时间为： " + (end - start));

        long start1 = System.currentTimeMillis();
        copyFileWithBufferIOStream("day17\\IOFile\\PictureTest.jpg","day17\\IOFile\\PictureTest1.jpg");
        long end1 = System.currentTimeMillis();
        System.out.println("使用BufferedIOStream复制非文本文件的时间为： " + (end1 - start1));
    }

    //使用FileIOStream复制非文本文件的方法
    public static void copyFileWithFileIOStream(String srcPath,String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try{
            fis = new FileInputStream(new File(srcPath));
            fos = new FileOutputStream(new File(destPath));

            byte[] buffer = new byte[10];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(fis != null)
                    fis.close();
                if (fos != null) {
                    fos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //使用BufferedIOStream复制非文本文件的方法
    public static void copyFileWithBufferIOStream(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try{
            bis = new BufferedInputStream(new FileInputStream(new File(srcPath)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(destPath)));

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(bis != null)
                    bis.close();
                if(bos != null)
                    bos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
