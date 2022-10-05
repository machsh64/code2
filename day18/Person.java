package day18;

import java.io.Serializable;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-05 19:04
 * @description:
 *
 *   Person类需要满足如下的要求，方可序列化
 *   1，需要实现接口 Serializable
 *   2，需要当前类提供一个全局常量serialVersionUID
 *   3，除了当前Person类需要实现Serializable接口之外，
 *      还必须保证其内部所有属性也必须是可序列化的（默认情况下，基本数据类型都可序列化）
 *
 *   补充： ObjectOutputStream和ObjectInputStream不能序列化static和transient修
 *         饰的成员变量
 **/
public class Person implements Serializable {

    private static final long serialVersionUID = -6849794470754667710L;

    private String name;
    private int age;
    private int id;
    private Account act;

    public Person() {
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age, int id, Account act) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.act = act;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAct() {
        return act;
    }

    public void setAct(Account act) {
        this.act = act;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                "\n, act=" + act +
                '}';
    }
}

class Account implements Serializable{

    private static final long serialVersionUID = -6849794470754667710L;

    private String name;
    private int age;

    public Account(String name, int age) {
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

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
