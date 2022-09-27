package day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-26 16:19
 * @description:
 *
 * 1，/----Collection接口：单列集合，用来存储一个一个的对象
 *         /----List接口：存储有序的，可重复的数据  --->“动态数组”，替换原有的数组
 *            /----ArrayList：作为List接口的主要实现类，线程不安全的，效率高  底层使用Object[] elementData存储
 *            /----linkedList：对于频繁的插入，删除操作，使用此类效率比ArrayList高   底层使用双向链表存储
 *            /----Vector：作为List接口的古老实现类，线程安全的，效率低  底层使用Object[] elementData存储
 *
 *   2，ArrayList的源码分析：
 *     2.1  jdk 7情况下
 *          ArrayList list = new ArrayList();  //底层创建了长度时10的Object[]数组elementData
 *          list.add(123);  //elementData[0] = new Integer(123);
 *          ...
 *          list.add(11);  //如果此次的添加导致底层elementData数组容量不够，则自动扩容
 *          默认情况下，扩容为原来容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *          结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity);
 *
 *     2.2 jdk 8中ArrayList的变化：
 *         ArrayList list = new ArrayList();  //底层Object[] elementData初始化为{} 并没有创建长度为10的数组
 *
 *         list.add(123);   //第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData[0]中
 *         ...
 *         后续的添加与扩容操作与jdk 7无异
 *     2.3 小结：jdk 7中的ArrayList的对象的创建类似于单例模式中的饿汉式，jdk 8中的ArrayList类似于懒汉式，延迟了数组的创建，节省内存
 *
 *    3，LinkedList的源码分析：
 *         LinkedList list = rew LinkedList();  内部声明了Node类型的first和last属性，默认为none
 *         list.add(123);   //将123封装到Node中，创建了Node对象
 *
 *         其中，Node定义为：体现了LinkedList的双向链表的说法
 *         private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *    4，Vector的源码分析：jdk 7和jdk 8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
 *            在扩容方面，默认扩容为原来的数组长度的2倍
 *
 *
 *     面试题：ArrayList，linkedList，Vector三者的异同
 *        同：三个类都实现了List接口，存储数据的特点相同：存储有序的，可重复的数据
 *       不同：见以上
 **/
@SuppressWarnings("unused")
public class ListTest {
    /**
    * Collection<String> arrayList = new ArrayList<>();
     *
     * List<Student> list = new ArrayList<>();
     *
     * 我们有时候会遇到上面的代码，不理解为什么这么写，下面我来分享一下自己的想法：
     *
     * 首先，当我们在写程序的时候不知道应该用哪一个集合更好的时候就可以这么写，直接使用父类，但是有个问题是父类不能自实现，所以只能new一个子类的对象，new出来的对象只能使用Collection的方法，不能使用arrayList的，这样的好处是当你想把你的集合改为linkedList的时候没有必要去修改方法，因为你没有使用arrayList的特有方法，但是这样写代码有一个地方要注意，当你想遍历这个对象的时候你得这么写：
     *
     * String[] array2 = arrayList .toArray(new String[] {});// new
     * // String[]{}仅仅只是为了确定方法泛型
     * for (String s : array2) {
     * System.out.println(s);
     * }
     * ————————————————
     */
    //源码直达
     ArrayList<Object> list = new ArrayList<>();

     Collection<Object> coll =  new ArrayList<>();
     Collection<Object> coll1 = new LinkedList<>();
     Collection<Object> coll2 = new Vector<>();
}




































