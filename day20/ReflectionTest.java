package day20;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-08 11:54
 * @description:
 **/
public class ReflectionTest {

    /**
     *  关于java.lang.Class类的理解
     *  1，类的加载过程：
     *   程序经过java.exe命令以后，会生成一个或多个字节码文件(.class结尾)，接着
     *    我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中，
     *    此过程就称为类的加载。加载到内存中的类，我们就成为运行时类，此运行时类，就作为Class的一个实例
     *
     *  2，换句话说，Class的实例就对应着一个运行时类
     *  3，加载到内存中的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式来获取此运行时类
     */

    //获取Class实例的方式
    @Test
    public void test() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<PersonTest> clazz1 = PersonTest.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象
        PersonTest p1 = new PersonTest();
        Class<? extends PersonTest> clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> clazz3 = Class.forName("day20.PersonTest");
        System.out.println(clazz3);
    }
    @Test
    public void testRe() throws Exception {
        Class<PersonTest> clazz = PersonTest.class;
        Constructor<PersonTest> constructor = clazz.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        PersonTest p1 = constructor.newInstance("Tom", 20);

        System.out.println(p1);

        //通过反射可以调用类中私有化的构造器
        constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        PersonTest p2 = constructor.newInstance("Jerry");

        System.out.println(p2);
        //通过反射可以调用类中私有化的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"zhuLI");

        System.out.println(p2);

        //通过反射可以调用类中私有化的方法
        Method nation = clazz.getDeclaredMethod("nation", String.class);
        nation.setAccessible(true);
        String nation1 = (String) nation.invoke(p2,"USA");
        System.out.println(nation1);

    }
}
