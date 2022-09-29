package day14;

import org.junit.Test;

import java.util.*;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-29 11:33
 * @description:
 **/
public class ListTrTest {
    //请从键盘随机输入5个整数保存到List中，并按倒序、从大到小的顺序显示出来
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int i = 5;
        while (i-- > 0) {
            list.add(scan.nextInt());
        }

        Collections.reverse(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

        System.out.println(list);
    }

    //请把学生名与考试分数录入到集合中，并按分数显示前三名
    //成绩学员的名字。
    //TreeSet(Student(name,score,id));
    @Test
    public void test2() {
        Comparator<Student> com = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -Integer.compare(o1.getScore(), o2.getScore());
            }
        };

        TreeSet<Student> set = new TreeSet<>(com);
        set.add(new Student("liwewe", 98, 1001));
        set.add(new Student("zhangdew", 22, 1002));
        set.add(new Student("hesd", 64, 1003));
        set.add(new Student("gawe", 47, 1004));
        set.add(new Student("dwar", 83, 1005));

        Iterator<Student> iterator = set.iterator();
        int i = 3;
        while (i-- > 0) {
            System.out.println(iterator.next());
        }

    }
}


class Student {
    private String name;
    private int score;
    private int id;

    public Student(String name, int score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                id == student.id &&
                Objects.equals(name, student.name);
    }
}