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

    //通配符的使用
    @Test
    public void test5() {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        List<?> list = null;
        list = list1;
        list = list2;
        //编译通过
//        print(list1);
//        print(list2);


        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加（写入）：对于List<?>就不能向其内部添加数据
        //除了添加null之外
//        list.add("AA");
        list.add(null);

        //允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);  //AA
        print(list);  //AA BB CC null
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    //有限制条件的通配符的使用
      /**
      *   ? extends A:  G<? extends A>  可以作为G<A> 和 G<B> 的子类 其中A是B的父类
       *  ? super B:    G<? super A>  可以作为G<A> 和 G<B> 的父类 其中B是A的父类
       */
      @Test
      public void test6() {
          List<? extends Person> list1 = null;
          List<? super Person> list2 = null;

          List<Student> list3 = new ArrayList<>();
          List<Person> list4 = new ArrayList<>();
          List<Object> list5 = new ArrayList<>();

          list1 = list3;
          list1 = list4;
        //  list1 = list5;   报错，要求list1 必须是继承或等于Person的类

        //  list2 = list3;   报错，要求list2 必须是Person的父类或者Person
          list2 = list4;
          list2 = list5;
      }
}
