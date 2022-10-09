package day20.java2.ConTest;

import day20.java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-09 15:30
 * @description: 获取运行时类的方法结构
 **/
public class MethodTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        //getMethods()：获取当前运行时类以及所有父类中声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //getDeclaredMethods()：获取当前运行时类中声明的所有方法（不包含父类中的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method deMethod : declaredMethods) {
            System.out.println(deMethod);
        }
    }

    //@Xxxx
    //权限修饰符  返回值类型  方法名 （参数类型1 形参名，...）throws XxxException{}
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method deMethod : declaredMethods) {
            //1，获取方法声明的注解
            Annotation[] annotations = deMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            //2，权限修饰符：获取每个方法的权限修饰符
            System.out.print(Modifier.toString(deMethod.getModifiers()) + "\t");

            //3，返回值类型
            System.out.print(deMethod.getReturnType().getName() + "\t");

            //4，方法名
            System.out.print(deMethod.getName() + "(");

            //5，形参列表
            Class<?>[] parameterTypes = deMethod.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.print(")");

            //6，抛出的异常
            Class<?>[] exceptionTypes = deMethod.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.println("throws");
                for(int i = 0; i < exceptionTypes.length; i++){
                   System.out.print(exceptionTypes[i].getName());
                }
            }

            System.out.println();
        }
    }
}
