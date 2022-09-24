package project.TeamSchedule.service;

import project.TeamSchedule.domain.Architect;
import project.TeamSchedule.domain.Designer;
import project.TeamSchedule.domain.Employee;
import project.TeamSchedule.domain.Programmer;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:38
 * @description: 公司开发团队类
 **/
public class TeamService {

    private int counter = 1;     //静态变量，用来为开发团队新增成员生成团队中唯一id
    private final int MAX_MEMBER = 5;    //静态常量，设置团队中最大成员数目 5
    private Programmer[] team = new Programmer[MAX_MEMBER];  //保存当前团队中各成员对象
    private static int total = 0;         //记录团队的实际人数

    public TeamService() {

    }

    public Programmer[] getTeam() throws RuntimeException{   //返回包含所有开发人员的数组team
        if (total == 0)
            throw new TeamException("开发团队暂时无人");
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    //添加成员的方法
    public void addMember(Employee e) throws RuntimeException {
        if (total >= MAX_MEMBER)
            throw new TeamException("添加失败：开发团队中人数最多为5人");
        if (!(e instanceof Programmer))
            throw new TeamException("添加失败：普通员工不能加入开发团队");
        Programmer p = (Programmer) e;

     /*   if (isExist(p))
            throw new TeamException("添加失败：该员工已在开发团队中");
        if (p.getStatus().getNAME().equals("BUSY"))
            throw new TeamException("添加失败：该成员已在某开发团队中");
        if (p.getStatus().getNAME().equals("VOCATION"))
            throw new TeamException("添加失败：该成员正在度假中");*/

        /** 9月24日 21:08 修改原因：枚举类的创建：enum Status*/
        switch(p.getStatus()){
            case BUSY:  throw new TeamException("添加失败：该成员已在某开发团队中");
            case VOCATION:  throw new TeamException("添加失败：该成员正在度假中");
        }


        int numProgrammer = 0, numDesigner = 0, numArchitect = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numArchitect++;
            } else if (team[i] instanceof Designer) {
                numDesigner++;
            } else if (team[i] instanceof Programmer) {
                numProgrammer++;
            }
        }

        if (p instanceof Architect) {
            if (numArchitect >= 1)
                throw new TeamException("添加失败：开发团队中最多只能有一位架构师");
        } else if (p instanceof Designer) {
            if (numDesigner >= 2)
                throw new TeamException("添加失败：开发团队中最多只能有两位设计师");
        } else if (p instanceof Programmer) {
            if (numProgrammer >= 3)
                throw new TeamException("添加失败：开发团队中最多只能有三位程序员");
        }

        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
        team[total++] = p;
        System.out.println("添加成功");
    }

    //检索成员是否已经在开发团队中的数组
    public boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
            if (p == team[i]) {
                return true;
            }
        }
        return false;
    }

    //删除成员的方法
    public void removeMember(int memberID) throws RuntimeException{
        int n = 0;
        for (; n < total; n++) {
            if (team[n].getMemberId() == memberID) {
                team[n].setStatus(Status.FREE);
                break;
            }
        }

        if (n == total)
            throw new TeamException("删除失败：开发团队中无此ID的成员");

        for (int i = n + 1; i < total; i++) {
            team[i - 1] = team[i];
        }
        team[--total] = null;
        System.out.println("删除成功");
    }
    
}
