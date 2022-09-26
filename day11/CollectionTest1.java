package day11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-26 12:45
 * @description:
 *    Collection接口中声明的方法的测试
 *    结论：
 *      向Collection接口的实现类的对象中添加数据obj时，要求重写obj中的equals()方法
 **/
public class CollectionTest1 {
    @Test
    public void test1() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        /*Person p =new Person("Jerry",20);*/
        /*coll.add(p);*/
        coll.add(new Person("Jerry",20));

        //1，contains(Object obj)：判断当前集合中是否包含obj     返回一个boolean类型
        //我们在判断时会调用obj对象所在类的equal()
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        /*System.out.println(coll.contains(p));*/  //true
        System.out.println(coll.contains(new Person("Jerry",20)));  //false ---> true

        //2，containsAll(Collection coll1)：判断形参coll1中的所有元素是否都存在于当前集合中   返回一个boolean类型
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));  //true
    }

    @Test
    public void test2() {
        //3，remove(Object obj)：从但钱集合中移除obj元素   返回一个boolean类型
        Collection<Object> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        System.out.println(coll);
        System.out.println("remove 123: " + coll.remove(123));
        System.out.println(coll.remove(new Person("Jerry",20)));
        System.out.println(coll);

        //4，removeAll(Collection coll1)：从当前集合中移除coll1中所有的元素
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add(456);
        coll1.add(false);
        System.out.println("remove coll1: " + coll.removeAll(coll1));
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //5，retainAll(Collection coll1)：交集：获取当前集合和coll1集合的交集，并返回给当前集合
        /*Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);*/

        //6，equals(Object obj)：要想返回true，需要当前集合和形参集合的所有元素都相同
        Collection<Object> coll1 = new ArrayList<>();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Jerry",20));

        System.out.println(coll.equals(coll1));  //true
    }

    @Test
    public void test4() {
        Collection<Object> coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //7，hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8，集合 ---> 数组：toArray() ：相当于集合到数组的转换
        Object[] arr = coll.toArray();
        for (Object o:arr){
            System.out.println(o);
        }

        //拓展：数组 ---> 集合：调用Arrays类的静态方法asList() ：相当于数组到集合的转换
        List<String> list = Arrays.asList(new String[]{"aa","bb","cc"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123,456});
        List<Integer> arr2 = Arrays.asList(new Integer[]{123,456});

        System.out.println(arr1.size());  //1
        System.out.println(arr2.size());  //2

        //9，iterator()：返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}
