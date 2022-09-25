package day10;


import java.util.ArrayList;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-25 17:23
 * @description:
 *   注解的使用
 *
 *   1，理解Annotation：
 *    ① JDK 5.0新增的功能
 *
 *    ② Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
 *      可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
 *
 *    ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
 *     用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 *
 *    2，Annotation的使用示例
 *      示例一：生成文档相关的注解
 *      示例二：在编译时进行格式检查（JDK内置的三个基本注解）
 *            、、@Override限定重写父类方法，该注解只能用于方法
 *            、、@Deprecated：用于表示所修饰的元素（类,方法等）已过时，通常是因为所修饰的结构危险或存在更好的选择
 *            、、@SuppressWarnings:抑制编译器警告
 *
 *       示例三：跟踪代码依赖性：实现代替配置文件功能
 *
 *    3，如何自定义注解：参照@SuppressWarning定义
 *      ①：注解声明为：@interface
 *      ②：内部定义成员，通常使用value表示
 *      ③：可以指定成员的默认值，使用default定义
 *      ④：如果自定义注解没有成员，表明是一个标识作用
 *
 *      如果注解有成员，在使用注解时，需要指明成员的值
 *      自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 *      自定义注解通常都会指明两个元注解：Retention(声明自定义注解周期)，Target(指定自定义注解能用于修饰那些元素)
 *
 *    4，jdk 提供的4种元注解
 *      元注解：对现有的注解解释说明的注解
 *     Retention：指定所修饰的Annotation 的声明周期：SOURCE，CLASS(默认行为)，RUNTIME
 *                只有声明为RUNTIME声明周期的直接，才能通过反射获取。
 *     Target：用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于修饰哪些程序元素。@Target({TYPE类, FIELD属性, METHOD方法, PARAMETER参数, CONSTRUCTOR构造器, LOCAL_VARIABLE})
 *             、@Target 也包含一个名为 value 的成员变量。
 *          ************出现的频率较低*******  ******
 *     Document：表示所修饰的注解在被Javadoc解析时，保留下来
 *     Inherited：所修饰的Annotation将具有继承性，用于修饰继承父类的方法
 *
 *    5，通过反射获取注解信息
 *
 *    6，jdk 8中注解的新特性，可重复注解，类型注解
 *
 *    6.1，可重复注解：① 在MyAnnotation上声明@repeatable，成员值为My Annotations.class
 *                  ② 在MyAnnotation的Target和Retention和MyAnnotation相同
 *
 **/
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

        @SuppressWarnings("unused")
        int num = 10;

        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list = new ArrayList();
    }

}


//jdk 8之前的重复注解写法
//@MyAnnotations(@MyAnnotation(value = "hell",@MyAnnotation(value = "hi")))

@MyAnnotation(value = "hell")
@MyAnnotation(value = "hi")
class Person {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}
