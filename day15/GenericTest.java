package day15;

import org.junit.Test;

import java.util.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-01 13:00
 * @description:
 *
 *   泛型的使用
 *   1，jdk 5.0新增的特性
 *
 *   2，在集合中使用泛型
 *   总结：
 *   ①：集合接口或集合类在jdk 5.0时都修改为带泛型的结构
 *   ②：在实例化集合类时，可以指明具体的泛型类型
 *   ③：指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法，构造器，属性等）
 *
 *   ④：注意点：泛型的类型把必须是类，不能是基本数据类型，需要用到基本数据类型的位置，拿包装类替换
 *   ⑤：如果实例化时：没有指明泛型的类型。默认类型为java.lang.Object类型
 *
 *   3，如何自定义泛型结构：泛型类，泛型接口；泛型方法。见：GenericTest1
 **/
public class GenericTest {  

    //在集合中使用泛型之前的情况
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(65);
        list.add(23);
        list.add(73);
        list.add(83);
        //问题一：类型不安全
        list.add("Yto");

        for (Object score : list) {
            //问题二：强转时有可能出现异常  java.lang.ClassCastException
            int stuScore = (Integer) score;  //String类型的Yto不可转换为int
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(84);
        list.add(85);
        list.add(87);
        //在编译时，就会进行类型检查，保证数据的安全
        //list.add("yto");

        /*for (Integer score : list) {
            //避免了强转操作
            System.out.println(score);
        }*/

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3() {
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",73);
        map.put("Jeck",84);
        map.put("GG",94);

        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry =map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry1 = iterator.next();
            System.out.println(entry1.getKey() + "---->" + entry1.getValue());
        }
        
        for (Map.Entry<String,Integer> entry2 : entry) {
            System.out.println(entry2.getKey() + "---->" + entry2.getValue());
        }

    }
    
    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法所属的类是不是泛型类都没有关系
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }

        //list.addAll(Arrays.asList(arr));list.addAll(Arrays.asList(arr));
        return list;
    }

    //测试泛型方法
    @Test
    public void test4() {
        Order<Integer> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }

}
