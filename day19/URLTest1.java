package day19;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-07 21:46
 * @description:
 **/
public class URLTest1 {
    public static void main(String[] args) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        OutputStream os = null;

        try {
            url = new URL("http://localhost:8080/examples/pic.jpg");
            urlConnection =(HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            os = new FileOutputStream("day19\\IOFile\\picTest.jpg");

            byte[] buffer = new byte[1024];
            int len;
                while((len = is.read(buffer)) != -1){
                    os.write(buffer,0,len);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null)
                    is.close();
                if(os != null)
                    os.close();
                if (urlConnection != null)
                    urlConnection.disconnect();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        new File("day19\\IOFile\\picTest.jpg").delete();
    }
}
