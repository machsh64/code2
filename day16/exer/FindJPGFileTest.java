package day16.exer;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

import org.junit.Test;
/**
 * 课后练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 * @author shkstart 邮箱：shkstart@126.com
 * @version  创建时间：2019年2月23日  上午1:55:59
 *
 */
public class FindJPGFileTest {

	@Test
	public void test1(){
		File srcFile = new File("D:\\machs\\Pictures\\album");
		
		String[] fileNames = srcFile.list();
		for(String fileName : fileNames){
			if(fileName.endsWith(".jpg")){
				System.out.println(fileName);
			}
		}
	}
	@Test
	public void test2(){
		File srcFile = new File("D:\\machs\\Pictures\\album");
		
		File[] listFiles = srcFile.listFiles();
		for(File file : listFiles){
			if(file.getName().endsWith(".jpg")){
				System.out.println(file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		File file = new File("D:\\machs");
		try {
			jpgFinder(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void jpgFinder(File file) {
		File[] files = file.listFiles();
		for (File filee : files) {
		    if (filee.getName().endsWith(".jpg")){
		    	System.out.println(filee.getAbsolutePath());
			}else if (filee.isDirectory()){
		    	jpgFinder(filee);
			}
		}
	}
	/*
	 * File类提供了两个文件过滤器方法
	 * public String[] list(FilenameFilter filter)
	 * public File[] listFiles(FileFilter filter)

	 */
	@Test
	public void test3(){
		File srcFile = new File("D:\\machs\\Pictures\\album");
		
		File[] subFiles = srcFile.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".jpg");
			}
		});
		
		for(File file : subFiles){
			System.out.println(file.getAbsolutePath());
		}
	}
	
}
