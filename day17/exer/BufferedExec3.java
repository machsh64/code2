package day17.exer;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-04 14:28
 * @description:
 * 1. 分别使用节点流：FileInputStream、FileOutputStream和缓冲流：
 *    BufferedInputStream、BufferedOutputStream实现文本文件/图片/视频文件的
 *    复制。并比较二者在数据复制方面的效率
 * 2. 实现图片加密操作。
 *    提示：
 * 3. 获取文本上每个字符出现的次数
 *    提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据
 *    写入文件
 **/
public class BufferedExec3 {
    /**
     * 3. 获取文本上每个字符出现的次数
     *    提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据
     *    写入文件
    */
    public static void main(String[] args) {
        getNumOfChar("day17\\IOFile\\hello.txt","day17\\IOFile\\hello1.txt");
    }

    //获取字符出现个数的方法
    public static void getNumOfChar(String srcPath,String destPath) {
        Map<Character,Integer> map = null;
        BufferedReader bfr = null;
        BufferedWriter bfw = null;

        try{
            bfr = new BufferedReader(new FileReader(new File(srcPath)));
            bfw = new BufferedWriter(new FileWriter(new File(destPath)));
            map = new HashMap<>();

            //将重复的字符存入Map中的操作
            int c;
            while ((c = bfr.read()) != -1){
                char cr = (char) c;
                if(map.get(cr) == null){
                    map.put(cr,1);
                }else {
                    map.put(cr,map.get(cr) +1);
                }
            }

            //将Map中的数据写出到文件中的操作
            Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
            Iterator<Map.Entry<Character,Integer>> iterator = entrySet.iterator();
            while(iterator.hasNext()){
                Map.Entry<Character,Integer> entry = iterator.next();
                String str = entry.getKey() + "---->" + entry.getValue();
                bfw.write(str + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(bfr != null)
                    bfr.close();
                if(bfw != null)
                    bfw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
