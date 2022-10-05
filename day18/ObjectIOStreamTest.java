package day18;

import org.junit.Test;

import java.io.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-05 14:57
 * @description:
 *
 *   对象流的使用
 *   1，ObjectInputStream 和 ObjectOutputStream
 *   2，作用：用于存储和读入基本数据类型或对象的处理流。它的强大之处就是可
 *      以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 *   3，要想一个java对象是可序列化的，需要满足相应的要求，见Person.java
 **/
public class ObjectIOStreamTest {

   /**
    *  序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    *  使用ObjectOutputStream实现
    */
   @Test
   public void testObjectOutputStream() {
       ObjectOutputStream oos = null;

       try{
           oos = new ObjectOutputStream(new FileOutputStream("day18\\IOFile\\object.dat"));
           oos.writeObject(new String("我爱北京天安门"));
           oos.flush();
           oos.writeObject(new Person("李宗伟",23,1001,new Account("张学良",25)));
           oos.flush();
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           try{
               if(oos != null)
               oos.close();
           }catch (IOException e){
               e.printStackTrace();
           }
       }
   }

    /**
     *反序列化：将磁盘文件中的对象还原为内存中的一个java对象
     *使用ObjectInputStream 来实现
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;

        try{
            ois = new ObjectInputStream(new FileInputStream("day18\\IOFile\\object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            Object obj1 = ois.readObject();
            Person p1 = (Person) obj1;
            System.out.println(p1);
        }catch (ClassNotFoundException|IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(ois != null)
                    ois.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
