package day16;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-02 12:59
 * @description:
 *    File类的使用
 *
 *    1，File类的一个对象，代表一个文件或一个文件目录（文件或文件夹）
 *    2，File类声明在java.io包下
 *    3，File类中涉及到关于文件或文件按目录的创建，删除，重命名，修改时间，文件大小等方法，并未涉及到写入或读取文件内容的操作。
 *       如果需要读取或写入文件内容，必须使用IO流来完成
 *    4，后续File类的对象常会作为参数传递到流的构造器中
 **/
public class FileTest {
    /**
     *  1，如何创建File类的实例
     *  2，
     *    相对路径：相较于某个路径下，指明的路径
     *    绝对路径：包含盘符在内的文件或文件夹目录的路径
     *
     *  3，路径分隔符
     *    windows： \\
     *    unix：/
     *
     */
    @Test
    public void test1() {
        //构造器1
        File file1 = new File("hello1.txt");  //相较于当前的module
        File file2 = new File("D:\\idea\\code2\\day16\\hello2.txt");

        System.out.println(file1);  //hello1.txt
        System.out.println(file2);  //D:\idea\code2\day16\hello2.txt

        //构造器2
        File file3 = new File("D:\\idea\\code2","day16");
        System.out.println(file3);  //D:\idea\code2\day16

        //构造器3
        File file4 = new File(file3,"hello4.txt");
        System.out.println(file4);  //D:\idea\code2\day16\hello4.txt
    }

    /**
      * public String getAbsolutePath()：获取绝对路径
     *  public String getPath() ：获取路径
     *  public String getName() ：获取名称
     *  public String getParent()：获取上层文件目录路径。若无，返回null
     *  public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     *  public long lastModified() ：获取最后一次的修改时间，毫秒值
      */
    @Test
    public void test2() {
        File file1 = new File("hello1.txt");  //相较于当前的module
        File file2 = new File("D:\\idea\\code2\\day16\\hello2.txt");

        System.out.println(file1.getAbsoluteFile());  //D:\IDEA\code2\hello1.txt  获取绝对路径
        System.out.println(file1.getPath());          //hello1.txt  获取路径
        System.out.println(file1.getName());          //hello1.txt  获取名称
        System.out.println(file1.getParent());        //null  获取上层文件目录路径。若无，返回null
        System.out.println(file1.length());           //0  获取文件长度（即：字节数）。不能获取目录的长度。
        System.out.println(file1.lastModified());     //0  获取最后一次的修改时间，毫秒值

        System.out.println("*********************");
        System.out.println(file2.getAbsoluteFile());  //D:\idea\code2\day16\hello2.txt  获取绝对路径
        System.out.println(file2.getPath());          //D:\idea\code2\day16\hello2.txt  获取路径
        System.out.println(file2.getName());          //hello2.txt  获取名称
        System.out.println(file2.getParent());        //D:\idea\code2\day16  获取上层文件目录路径。若无，返回null
        System.out.println(file2.length());           //0  获取文件长度（即：字节数）。不能获取目录的长度。
        System.out.println(new Date(file2.lastModified()));     //0  获取最后一次的修改时间，毫秒值
    }

    /**
     * public boolean renameTo(File dest):把文件重命名为指定的文件路径
     * 比如：file1.renameTo(file2)为例：
     *   要想保证返回true，则file1在硬盘中是存在的，且file2不能在硬盘中存在
     */
    @Test
    public void test3() {
        File file1 = new File("hello1.txt"); //相较于当前的module
        File file2 = new File("D:\\idea\\code2\\day16\\hello2.txt");
        boolean removeTo = file1.renameTo(file2);
        System.out.println(removeTo);
    }

    /**
     *  public boolean isDirectory()：判断是否是文件目录
     *  public boolean isFile() ：判断是否是文件
     *  public boolean exists() ：判断是否存在
     *  public boolean canRead() ：判断是否可读
     *  public boolean canWrite() ：判断是否可写
     *  public boolean isHidden() ：判断是否隐藏
    */
    @Test
    public void test4() {
        File file1 = new File("hello1.txt"); //相较于当前的module
        File file2 = new File("D:\\idea\\code2\\day16\\hello2.txt");
        System.out.println( "判断是否是文件目录 " + file1.isDirectory());  //判断是否是文件目录 false
        System.out.println("判断是否是文件" + file1.isFile());  //判断是否是文件false
        System.out.println("判断是否存在 " + file1.exists());   //判断是否存在 false
        System.out.println("判断是否可读" + file1.canRead());   //判断是否可读false
        System.out.println("判断是否可写" + file1.canWrite());  //判断是否可写false
        System.out.println("判断是否隐藏" + file1.isHidden());  //判断是否隐藏false

        System.out.println("**************************");
        System.out.println( "判断是否是文件目录 " + file2.isDirectory());   //判断是否是文件目录 false
        System.out.println("判断是否是文件" + file2.isFile());   //判断是否是文件true
        System.out.println("判断是否存在 " + file2.exists());    //判断是否存在 true
        System.out.println("判断是否可读" + file2.canRead());    //判断是否可读true
        System.out.println("判断是否可写" + file2.canWrite());   //判断是否可写true
        System.out.println("判断是否隐藏" + file2.isHidden());   //判断是否隐藏false
    }

    /**
     *  public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     *  public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     *  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
    */
    @Test
    public void test5() throws IOException {
        File file1 = new File("D:\\idea\\code2\\day16\\hello3.txt");
        if (!file1.exists()){
            System.out.println("文件创建 ： " + file1.createNewFile());
        }else {
            System.out.println("文件删除 ： " + file1.delete());
        }
    }

    /**
     *  public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     *  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
     */
    @Test
    public void test6() {
        File file1 = new File("D:\\idea\\code2\\day16\\io");
        System.out.println("文件夹创建 ： " + file1.mkdir());

        File file2 = new File("D:\\idea\\code2\\day16\\io2\\io3");
        System.out.println("文件夹创建io3 ： " + file2.mkdir());
        File file3 = new File("D:\\idea\\code2\\day16\\io2\\io4");
        System.out.println("文件夹创建io4 ： " + file3.mkdirs());


        /*File file2 = new File("D:\\idea\\code2\\day16\\hello2.txt");
        File file3 = new File("D:\\idea\\code2\\day16\\io\\hello2.txt");
        file2.renameTo(file3);*/
    }
}
