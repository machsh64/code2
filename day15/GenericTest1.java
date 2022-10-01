package day15;

import day11.Person;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-01 13:45
 * @description: 如何自定义泛型结构：泛型类，泛型接口；泛型方法
 **/
public class GenericTest1 {
    @Test
    public void test1() {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类时带泛型的，建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<>("orderAA", 1001, "order...");
        order1.setOrderT("AA:hello");
    }

    @Test
    public void test2() {
        subOrder sub1 = new subOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不在需要指明泛型
        sub1.setOrderT(1122);
        System.out.println(sub1.OrderT);

        subOrder1<String> sub2 = new subOrder1<>();
        sub2.setOrderT("order2...");
    }

    @Test
    public void test3() {

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        //泛型不同的引用不能相互赋值
  //    list1 =  list2;

        Person p1 = null;
        Person p2 = null;
        p1 = p2;

    }
}
