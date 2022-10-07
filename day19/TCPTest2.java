package day19;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-07 17:47
 * @description:
 *
 *   例题2：客户端发送文件到服务端，服务端将文件保存到本地
 **/
public class TCPTest2 {

    //客户端
    @Test
    public void client() {
        InetAddress inet = null;
        Socket socket = null;
        BufferedInputStream bis = null;
        OutputStream os = null;

        try{
            //1，创建Socket对象
            inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            //2，获取输入输出流
            os = socket.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream("day18\\IOFile\\PictureTest.jpg"));

            //3，读取以及写出数据
            /*os.write("你好，我是客户端1".getBytes());*/
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4，关闭资源
            try{
                if(bis != null)
                    bis.close();
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
        BufferedOutputStream bos = null;

        try{
            //1，创建服务区端的ServerSocket对象，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2，调用accept()表示接受来自于客户端的socket
            socket = serverSocket.accept();

            //3，获取输入输出流
            is = socket.getInputStream();
            /*bos = new FileOutputStream("day19\\IOFile\\client.txt");*/
            bos = new BufferedOutputStream(new FileOutputStream("day19\\IOFile\\PictureTest.jpg"));

            //4，读取以及写出数据
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //5，关闭资源
                if (is != null)
                    is.close();
                if (bos != null)
                    bos.close();
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
