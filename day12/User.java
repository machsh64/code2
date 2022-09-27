package day12;

import java.util.Objects;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-27 17:59
 * @description:
 **/
public class User implements Comparable {
    private String name;
    private int age;

    public User(String name, int age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals ...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User u = (User) o;
            //按年龄从小到大排
            /*return Double.compare(this.age,u.age);*/
            //按姓名从小到大排
            int compare = this.name.compareTo(u.name);
            if (compare != 0) {
                return compare;
            } else if (compare == 0) {
                return Double.compare(this.age,u.age);
            }
        }
        throw new RuntimeException();
    }
}
