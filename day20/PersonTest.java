package day20;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-08 11:55
 * @description:
 **/
public class PersonTest {
    private String name;
    private int age;

    public PersonTest() {
    }

    public PersonTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private PersonTest(String name) {
        this.name = name;
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

    public void show(){
        System.out.println("我是一个人");
    }

    private String nation(String nation){
        System.out.println("我的国籍是 " + nation);
        return nation;
    }
    @Override
    public String toString() {
        return "PersonTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
