package project.TeamSchedule.domain;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:39
 * @description: 员工总父类
 **/
public class Employee {

    private int id;    //id号
    private String name;    //员工姓名
    private int age;     //员工年龄
    private double salary;    //员工工资

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    private String work;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) { this.salary = salary; }

    //返回操作设备
    public String toString2() {
        return "\t";
    }

    //通过继承返回不同员工的 奖金，股票
    public String toString3(){
        return "";
    }

    //通过继承返回不同员工的 状态，奖金，股票
    public String toString1() {
        return "";
    }

    //返回基础信息  id name salary work
    @Override
    public String toString() {
        if (work == null) {
            return
                    "" + id +
                            "\t" + name +
                            "\t" + age +
                            "\t  " + salary +
                            "\t";
        } else {
            return
                    "" + id +
                            "\t" + name +
                            "\t" + age +
                            "\t  " + salary +
                            "\t" + getWork();
        }
    }

}
