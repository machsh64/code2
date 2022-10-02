package day16.exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-02 14:13
 * @description:
 **/
public class FileExer {
  /**
   * 1. 利用File构造器，new 一个文件目录file
   * 1)在其中创建多个文件和目录
   * 2)编写方法，实现删除file中指定文件的操作
   */
    @Test
    public void test1() throws IOException {
        File file1 = new File("D:\\idea\\code2\\day16\\exer\\file");
        System.out.println("file文件目录的创建： " + file1.mkdir());

        File file2 = new File("D:\\idea\\code2\\day16\\exer\\file\\test.txt");
        if (!file2.exists()){
            System.out.println("文件创建： " + file2.createNewFile());
        }else {
            System.out.println("文件创建失败");
        }

        System.out.println("文件删除：" + deleteFile(file2));
    }

    public static boolean deleteFile(File file){
        return file.delete();
    }
}
