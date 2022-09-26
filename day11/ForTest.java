package day11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-26 15:46
 * @description:
 * jdk 5.0新增了foreach循环，用于遍历集合，数组
 **/
public class ForTest {

    @Test
    public void test1() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        for (Object obj : coll) {
           System.out.println(obj);
        }
    }

    @Test
    public void test2() {
       int[] arr = new int[]{1,2,3,4,5,6};
       for (int arr1 : arr) {
          System.out.println(arr1);
       }
    }

    @Test
    public void test3() {
       String[] arr = new String[]{"MM","MM","MM"};
       for (String arr1 : arr) {
          arr1 = "GG";
       }
       for (String arr1 : arr) {
          System.out.println(arr1);
       }
    }
}
