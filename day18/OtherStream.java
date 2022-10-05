package day18;

import org.junit.Test;

import java.io.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-05 13:47
 * @description:
 **/
public class OtherStream {

    /**
     * 数据流的使用
     * DataInputStream 和 DataOutputStream
     * 作用 ：用于读取或写出基本数据类型的变量或字符串
     * <p>
     * 练习：将内存中的字符串，基本数据类型写出到文件中
     */
    @Test
    public void testDataOutputStream() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("day18\\IOFile\\destData.dat"));

            dos.writeUTF("赵子龙");
            dos.writeInt(29);
            dos.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null)
                    dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testDataInputStream() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("day18\\IOFile\\destData.dat"));

            String name = dis.readUTF();
            int age = dis.readInt();
            boolean gender = dis.readBoolean();

            System.out.println(name + " " + age + " " + gender);  //赵子龙 29 true
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null)
                    dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
