package day18;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-05 21:09
 * @description:
 **/
public class FileUtilsTest {
    public static void main(String[] args) {
        File srcFile = new File("day18\\IOFile\\PictureTest.jpg");
        File destFile = new File("day18\\IOFile\\PictureTest3.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
