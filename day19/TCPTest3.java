package day19;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-07 18:25
 * @description:
 *
 *    例题3：从客户端发送文件给服务端，服务端保存到本地。
 *         并返回“发送成功”给客户端。并关闭相应的连接。
 **/
public class TCPTest3 {

    //客户端
    @Test
    public void client() {
        InetAddress inet = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

        try{
            //1，创建Socket对象
            inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            //2，获取输入输出流
            os = socket.getOutputStream();
            fis = new FileInputStream("day18\\IOFile\\PictureTest.jpg");

            //3，写出数据到客户端
            /*os.write("你好，我是客户端1".getBytes());*/
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();

            //接受来自于服务器端的数据，并显示在控制台
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while((len1 = is.read(buffer1)) != -1){
                baos.write(buffer1,0,len1);
            }
            System.out.println(baos.toString());

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4，关闭资源
            try{
                if(baos != null)
                    baos.close();
                if(fis != null)
                    fis.close();
                if(os != null)
                    os.close();
                if(socket != null)
                    socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //服务端
    @Test
    public void sever() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        FileOutputStream fos = null;

        try{
            //1，创建服务区端的ServerSocket对象，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2，调用accept()表示接受来自于客户端的socket
            socket = serverSocket.accept();

            //3，获取输入输出流
            is = socket.getInputStream();
            /*os = new FileOutputStream("day19\\IOFile\\client.txt");*/
            fos = new FileOutputStream("day19\\IOFile\\PictureTest.jpg");

            //4，读取客户端 以及 写出到本地数据
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            System.out.println("图片传输完成");
            //服务器端给与客户端反馈
            os = socket.getOutputStream();
            os.write("发送成功".getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //5，关闭资源
                if (is != null)
                    is.close();
                if (fos != null)
                    fos.close();
                if(socket != null)
                    socket.close();
                if(serverSocket != null)
                    serverSocket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
