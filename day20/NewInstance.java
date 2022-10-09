package day20;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Random;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-09 11:44
 * @description:
 *
 *   通过反射创建对应的运行时类的对象
 **/
public class NewInstance {

    @Test
    public void test1() throws Exception{
        Class<PersonTest> clazz = PersonTest.class;
        Constructor<PersonTest> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        PersonTest p1 = constructor.newInstance("李明",23);
        System.out.println(p1);
        /**
         *newInstance()：调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参构造器
         *              要想此方法正确的创建运行时类的对象，要求：
         *              1，运行时类必须提供对应的构造器（空参/属性）
         *              2，空参的构造器的访问权限给的够。通常，设置为public
         *
         *              在javabean中要求提供一个public的空参构造器。原因：
         *              1，便于通过反射，创建运行时类的对象
         *              2，便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        PersonTest p2 = clazz.newInstance();
        System.out.println(p2);
    }

    //体会反射的动态性
    @Test
    public void test2() throws Exception {
        for(int i = 0; i < 20; i++){
            String classPath;
            int rom = new Random().nextInt(3);  //0 1 2
            switch (rom){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "day20.PersonTest";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + rom);
            }
            Object obj = getInstance(classPath);
            System.out.println(obj);
        }
    }
    /**
     * 创建一个指定类的对象
     */
    public Object getInstance(String classPath) throws Exception{
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
