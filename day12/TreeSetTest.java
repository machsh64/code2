package day12;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-27 19:02
 * @description:
 **/
public class TreeSetTest {
    /**
     * 1，向TreeSet中添加的数据，要求是相同类的对象。
     * 2，两种排序方式：自然排序（实现Comparable接口）  和  定制排序（Comparator）
     *
     * 3，自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()。
     *
     */

    @Test
    public void test1() {
       TreeSet<Object> set = new TreeSet<>();

       //失败：不能添加不同类的对象
     /*  set.add(123);
       set.add(456);
       set.add("AA");
       set.add(new User("Ton",12));*/

        //举例一：
       /* set.add(123);
        set.add(456);
        set.add(-12);
        set.add(41);*/

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",32));
        set.add(new User("Jack",56));

        Iterator<Object> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Comparator<Object> com = new Comparator<Object>() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException();
            }
        };
       TreeSet<Object> set = new TreeSet<>(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",32));
        set.add(new User("Mary",32));
        set.add(new User("Jack",56));

        Iterator<Object> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
