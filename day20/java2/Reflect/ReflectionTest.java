package day20.java2.Reflect;

import day20.java2.Person;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-09 16:30
 * @description:  调用运行时类中指定的结构：属性，方法，构造器
 **/
public class ReflectionTest {

    /**
     * 如何操作运行时类中指定的属性  -- 需要掌握
     */
    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;
        //创建运行时类的对象
        Person p1 = clazz.newInstance();
        //获取运行时类中指明变量名的属性
        Field id = clazz.getDeclaredField("id");
        //设置当前属性的值：
        //set()：参数1：指明设置那个对象的属性  参数2：将此属性值设置为多少
        id.set(p1,1001);
        int ids = (int) id.get(p1);
        System.out.println(ids);

        //1，getDeclaredFiled(String fieldName)：获取运行时类中指明变量名的属性
        Field age = clazz.getDeclaredField("age");
        //2，保证当前属性是可访问的
        age.setAccessible(true);
        //3，获取，设置指定对象的此属性值
        age.set(p1,10);
        int ages = (int) age.get(p1);
        System.out.println(ages);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"黎明");
        String names = (String) name.get(p1);
        System.out.println(names);

        System.out.println(p1);
    }

    /**
     *如何操作运行时类中的指定的方法 -- 需要掌握
     */
    @Test
    public void testMethod() throws Exception{
        Class<Person> clazz = Person.class;
        Person p1 = clazz.newInstance();

        //1，获取指定的某个方法 getDeclaredMethod()：参数1：指明方法的名称 参数2：指明方法形参列表的数据类型的反射
        Method show = clazz.getDeclaredMethod("show", String.class);
        //2，保证当前方法是可访问的
        show.setAccessible(true);
        //3，调用方法 invoke()：参数1：方法的调用者  参数2：给方法形参复制的实参
        String nation = (String) show.invoke(p1, "USA");
        System.out.println(nation);
    }

    /**
     *如何操作运行时类中的指定的构造器 -- 需要掌握
     */
    @Test
    public void testConstructor() throws Exception{
        Class<Person> clazz = Person.class;
        //1，获取指定的构造器 getDeclaredConstructor()： 参数：指明构造器的参数列表
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        //2，保证此构造器是可访问的
        constructor.setAccessible(true);
        //3，调用此构造器创建运行时类的对象
        Person p1 = constructor.newInstance("黎明", 10);
        System.out.println(p1);
    }
}
