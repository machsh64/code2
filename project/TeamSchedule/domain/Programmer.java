package project.TeamSchedule.domain;

import project.TeamSchedule.service.Status;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:52
 * @description: 程序员（programmer）__员工Employee的子类
 **/
public class Programmer extends project.TeamSchedule.domain.Employee {

    private int memberId = 0;   //程序员加入开发团队后在团队中的id号
    private Status status = Status.FREE;    //员工状态
    private Equipment equipment;    //该员工领用的设备

    public Programmer(int id, String name, int age, double salary, project.TeamSchedule.domain.Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
        setWork("程序员");
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(project.TeamSchedule.domain.Equipment equipment) {
        this.equipment = equipment;
    }

    //团队列表
    @Override
    public String toString3() {
        return "";
    }

    //公司列表
    @Override
    public String toString2(){
        return super.toString2() + equipment.getDescription();
    }

    //通过继承返回不同员工的奖金，股票
    @Override
    public String toString1() {
        return super.toString1() + "\t" + getStatus();
    }
}
