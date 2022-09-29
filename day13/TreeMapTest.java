package day13;

import day12.User;
import org.junit.Test;

import java.util.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-29 09:36
 * @description:
 **/
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按key进行排序：自然排序，定制排序

    //自然排序
    @Test
    public void test1() {
        TreeMap<User,Integer> map = new TreeMap<>();
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test2() {
        TreeMap<User,Integer> map = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });

        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

}
