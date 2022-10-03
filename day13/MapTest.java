package day13;

import org.junit.Test;

import java.util.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-28 10:48
 * @description:
 *    /----Map：双列数据，存储key-value对的数据     ----类似于高中的函数：y = f(x)
 *       /----HashMap：作为Map的主要实现类；线程不安全的，效率高； 存储null的key和value
 *          /----LinkedHashMap：保证在遍历map元素是，可以按照添加的顺序实现遍历
 *                                原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                                对于频繁的遍历操作，此类执行效率高于HashMap
 *       /----TreeMap：保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                     底层使用红黑树排序
 *       /----Hashtable：作为古老的实现类； 线程安全的，效率低；  不能存储null的key和value
 *          /----Properties：常用来处理配置文件。key和value都是String
 *
 *
 *      HashMap的底层：数组+链表 （jdk 7及之前）
 *                    数组+链表+红黑树 （jdk 8）
 *
 *    二：Map结构的理解：
 *       Map中的key：无序的，不可重复的，使用Set存储所有的key   --- key所在的类要重写equals()和hashCode()  （以HashSet为例）
 *       Map中的value：无序的，可重复的，使用Collection存储所有的value    ---value所在类要重写equals()
 *       一个键值对：key-value构成了一个Entry对象
 *       Map中的entry：无序的，不可重复的，使用Set存储所有的entry
 *
 *    三，HashMap的底层实现原理？  以jdk 7为例说明
 *       HashMap map = new HashMap();
 *       在实例化以后，底层创建的长度是16的一堆数组Entry[] table
 *       。。。可能已经执行过多次put。。。
 *       map.put(key1,value1)：
 *       首先，调用
 *
 *       map的常用方法：
 *        添加、删除、修改操作：
 *        Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *        void putAll(Map m):将m中的所有key-value对存放到当前map中
 *        Object remove(Object key)：移除指定key的key-value对，并返回value
 *        void clear()：清空当前map中的所有数据
 *        元素查询的操作：
 *        Object get(Object key)：获取指定key对应的value
 *        boolean containsKey(Object key)：是否包含指定的key
 *        boolean containsValue(Object value)：是否包含指定的value
 *        int size()：返回map中key-value对的个数
 *        boolean isEmpty()：判断当前map是否为空
 *        boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *        元视图操作的方法：
 *        Set keySet()：返回所有key构成的Set集合
 *        Collection values()：返回所有value构成的Collection集合
 *        Set entrySet()：返回所有key-value对构成的Set集合
 *
 *       总结：常用方法
 *         添加：put(Object key,Object value);
 *         删除：remove(Object key)
 *         修改：put(Object key,Object value1)
 *         查询：get(Object key)
 *         长度：size()
 *         遍历：keySet() / values() / entrySet()
 **/
public class MapTest {

    @Test
    public void test1() {
        Map<Integer,String> map = new HashMap<>();
        //Hash table不可以存储null的key和value
        /*map = new Hashtable();*/
        map.put(null, null);
    }

    @Test
    public void test2() {
        Map<Integer, String> map = new HashMap<>();
        map = new LinkedHashMap<>();
        map.put(123, "AA");
        map.put(345, "BB");
        map.put(12, "CC");

        System.out.println(map);
    }

    /**
     *  添加、删除、修改操作：
     *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *  void putAll(Map m):将m中的所有key-value对存放到当前map中
     *  Object remove(Object key)：移除指定key的key-value对，并返回value
     *  void clear()：清空当前map中的所有数据
     */
    @Test
    public void test3() {
        Map<Object, Object> map = new LinkedHashMap<>();
        //添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //修改  key相同的情况下，value不同则为修改
        map.put("AA", 87);

        System.out.println(map);  //{AA=87, 45=123, BB=56}

        Map<Object, Object> map1 = new LinkedHashMap<>();
        map1.put("CC", 123);
        map1.put("DD", 123);

        map.putAll(map1);
        System.out.println(map);  //{AA=87, 45=123, BB=56, CC=123, DD=123}

        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);  //123
        System.out.println(map);  //{AA=87, 45=123, BB=56, DD=123}

        //clear()
        map.clear();
        System.out.println(map.size());  //0
        System.out.println(map);  //{}
    }

    /**
     *  元素查询的操作：
     *  Object get(Object key)：获取指定key对应的value
     *  boolean containsKey(Object key)：是否包含指定的key
     *  boolean containsValue(Object value)：是否包含指定的value
     *  int size()：返回map中key-value对的个数
     *  boolean isEmpty()：判断当前map是否为空
     *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test4() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        //Object get(Object key);
        System.out.println(map.get(45));  //123

        //boolean containsKey(Object key)     检测map中是否有 参数为key 的key
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);  //true

        //boolean containsValue(Object value)     检测map中是否有 参数为value 的value
        isExist = map.containsValue(123);
        System.out.println(isExist);  //true

        map.clear();
        //boolean isEmpty()     检测map是否为空
        System.out.println(map.isEmpty());   //true
    }

    /**
     *  元视图操作的方法：
     *  Set keySet()：返回所有key构成的Set集合
     *  Collection values()：返回所有value构成的Collection集合
     *  Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test5() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        //遍历所有的key集  keySet()
        Set<Object> set = map.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            /*System.out.println(map.get(iterator.next()));*/
        }

        //遍历所有的value集  values()
        Collection<Object> coll = map.values();
        Iterator<Object> iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("*************");
        //遍历所有的key-value
        //方式一：entrySet();
        Set<Map.Entry<Object,Object>> entrySet = map.entrySet();
        Iterator<Map.Entry<Object,Object>> iterator2 = entrySet.iterator();
        while(iterator2.hasNext()){
            Map.Entry<Object,Object> entry = iterator2.next();
            System.out.println(entry.getKey()+"---->"+entry.getValue());
        }

        System.out.println("*************");
        //方式二：
        Set<Object> set1 = map.keySet();
        Iterator<Object> iterator3 = set1.iterator();
        while (iterator3.hasNext()) {
            Object key = iterator3.next();
            Object value = map.get(key);
            System.out.println( key + "---->" + value);
        }
    }
}





















