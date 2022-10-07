package day19;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-07 16:59
 * @description:
 *
 *   实现TCP的网络编程
 *    例题1： 客户端发送信息给服务端，服务端将数据显示在控制台上
 **/
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        InetAddress inet1 = null;
        Socket socket = null;
        OutputStream os = null;

        try{
            //1，创建Socket对象，指明服务器端的ip和端口号
            inet1 = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet1,8899);
            //2，获取一个输出流，用于输出数据
            os = socket.getOutputStream();

            //3，写出数据
            os.write("你好，我是客户端".getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //4，关闭资源
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
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try{
            //1，创建服务区端的ServerSocket对象，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2，调用accept()表示接受来自于客户端的socket
            socket = serverSocket.accept();
            //3，获取输入流
            is = socket.getInputStream();

            //不建议这样写，可能会有乱码
            /*byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }*/

            //4，读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自于： " + socket.getInetAddress().getHostName() + "的信息");

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //5，关闭资源
            try{
                if(baos != null)
                    baos.close();
                if(is != null)
                    is.close();
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
