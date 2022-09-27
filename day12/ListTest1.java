package day12;

import day11.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-26 17:40
 * @description:
 *
 *     5，List接口中的常用方法
 **/
public class ListTest1 {

    /** List除了从Collection集合继承的方法外，List 集合里添加了一些根据索引来操作集合元素的方法。
      *   void add(int index, Object ele):在index位置插入ele元素
      *   boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
      *   Object get(int index):获取指定index位置的元素
      *   int indexOf(Object obj):返回obj在集合中首次出现的位置
      *   int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
      *   Object remove(int index):移除指定index位置的元素，并返回此元素
      *   Object set(int index, Object ele):设置指定index位置的元素为ele
      *   List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
      *
      *  总结：常用方法
      *    增：void add(int index)
     *     删：Object remove(int index) / Object remove(Object obj)
     *     改：Object set(int index, Object ele)
     *     查：Object get(int index)
     *     插：void add(int index, Object ele)
     *     长度：size()
     *     遍历：① Iterator迭代器方式
     *          ② 增强型for循环
     *          ③ 普通的循环
      */
    @Test
    public void test1() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(new Person("LiLi",10));
        list.add("AA");

        System.out.println(list);  //[123, 456, Person{name='LiLi', age=10}, AA]   size: 4

        //void add(int index, Object ele);  在index位置插入ele元素
        list.add(2,"CC");
        System.out.println(list);  //[123, 456, CC, Person{name='LiLi', age=10}, AA]   size: 5

        //boolean addAll(int index, Collection eles); 从index开始将eles中所有的元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(3,list1);
        System.out.println(list);  //[123, 456, CC, 1, 2, 3, Person{name='LiLi', age=10}, AA]   size: 8

        //Object get(int index);  获取指定index位置的元素
        System.out.println(list.get(1));   //456
    }

    @Test
    public void test2() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(new Person("LiLi",10));
        list.add(456);
        list.add("AA");
        System.out.println(list);

        //indexOf(Object obj);  返回obj在集合中首次出现的位置，如果不存在，就返回-1
        int index = list.indexOf(456);
        System.out.println(index);  //1

        //int LastIndexOf(Object obj);  返回obj在当前集合中末次出现的位置
        int index1= list.lastIndexOf(456);
        System.out.println(index1);  //3

        //Object remove(int Index);  删除指定Index位置上的元素，并返回此元素
        Object obj = list.remove(1);
        System.out.println("removed: " + obj);  //removed: 456
        System.out.println(list);  //[123, Person{name='LiLi', age=10}, 456, AA]

        //Object set(int Index, Object ele);   设置指定Index位置的元素为ele
        list.set(3,"BB");
        System.out.println(list);  //[123, Person{name='LiLi', age=10}, 456, BB]

        //List subList(int formIndex, int toIndex);  返回从fromIndex到toIndex位置的左闭由开区间的数组
        List subList = list.subList(1,3);
        System.out.println(subList);  //[Person{name='LiLi', age=10}, 456]
        System.out.println(list);     //[123, Person{name='LiLi', age=10}, 456, BB]
    }

    //ArrayList的遍历
    @Test
    public void test3() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(new Person("LiLi",10));
        list.add(456);
        list.add("AA");

        //方式一：Iterator迭代器方式
        Iterator iterator =  list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("\n************\n");

        //方式二：增强型for循环方式
        for (Object ele : list) {
           System.out.println(ele);
        }

        System.out.println("\n************\n");

        //方式三：普通的循环
        Object[] arr = list.toArray();
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
