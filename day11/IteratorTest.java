package day11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-26 14:51
 * @description:
 *    集合元素的遍历操作，使用Iterator接口
 *    1，内部的方法：hasNext(),next()
 *    2，集合对象每次调用iterator()方法都会得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 *    3，内部定义了一个remove()，可以在遍历的时候，删除集合中的元素，此方法不同于集合直接调用remove()
 **/
public class IteratorTest {
    @Test
    public void test1() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        Iterator iterator = coll.iterator();
        //方式一：
        /*System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        //报异常：java.util.NoSuchElementException
      *//*  System.out.println(iterator.next());*/

        //方式二：不推荐
     /*   for (int i = 0;i <= coll.size();i++){
            System.out.println(iterator.next());
        }*/

        //方式三：推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //测试Iterator中的remove()：
    @Test
    public void test2() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //删除集合中”Tom“
        Iterator<Object> iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if (obj.equals("Tom")){
                iterator.remove();
            }
        }
        /* coll.removeIf(obj -> obj.equals("Tom"));*/

        //遍历集合
        Iterator<Object> iterator1 = coll.iterator();
        while(iterator1.hasNext()) {
           System.out.println(iterator1.next());
        }
    }
}
