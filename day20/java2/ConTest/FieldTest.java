package day20.java2.ConTest;

import day20.java2.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-09 15:13
 * @description: 获取当前运行时类的属性结构
 **/
public class FieldTest {
    @Test
    public void test1() {
        Class<?> clazz = Person.class;

        //获取属性结构
        //getFields()：获取当前运行时类及其父类中声明为public的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("**************");
        //getDeclaredFields()：获取当前运行类中声明的所有属性。(不包含父类中声明的属性)
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
    }

    //权限修饰符  数据类型  变量名
    @Test
    public void test2() {
        Class<?> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //1，权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //2，数据类型
            Class<?> type = field.getType();
            System.out.print(type + "\t");
            //3，变量名

            System.out.println();
        }
    }
}
