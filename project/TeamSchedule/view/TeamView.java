package project.TeamSchedule.view;

import project.TeamSchedule.domain.Architect;
import project.TeamSchedule.domain.Designer;
import project.TeamSchedule.domain.Programmer;
import project.TeamSchedule.service.NameListService;
import project.TeamSchedule.service.TeamService;

import java.util.Scanner;


/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:36
 * @description: 用户界面
 **/
public class TeamView {
    NameListService listSvc = new NameListService();
    TeamService teamSvc = new TeamService();
    Scanner scan = new Scanner(System.in);

    /**
     * @Param: 主界面显示及控制方法
     * @Author: Ren
     * @return:
     * @Date: 2022/9/14 18:43
     */
    public void enterMainMean() {

        boolean isFlag = true;
        while (isFlag) {
            listAllEmployees();
            int num = TSUtility.readMenuSelection();
            switch (num) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    isFlag = false;
            }
        }

    }

    //以表格形式列出公司所有成员
    private void listAllEmployees() {
        System.out.println("-------------------------------开发团队调度软件-------------------------------");
        System.out.println("ID\t姓名\t\t年龄\t  工资\t\t职位\t\t状态\t\t奖金\t\t  股票\t领用设备");
        for (int i = 0; i < listSvc.getAllEmployees().length; i++) {
            String list = listSvc.getAllEmployees()[i].toString();
            if (listSvc.getAllEmployees()[i] instanceof Architect) {
                list = list + listSvc.getAllEmployees()[i].toString1() + listSvc.getAllEmployees()[i].toString2();
            } else if (listSvc.getAllEmployees()[i] instanceof Designer) {
                list = list + listSvc.getAllEmployees()[i].toString1() + "\t\t" + listSvc.getAllEmployees()[i].toString2();
            } else if (listSvc.getAllEmployees()[i] instanceof Programmer) {
                list = list + listSvc.getAllEmployees()[i].toString1() + "\t\t\t" + listSvc.getAllEmployees()[i].toString2();
            }
            System.out.println(list);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
    }

    //显示团队成员列表操作
    private void getTeam(){
        try{
            teamSvc.getTeam();    //为了使this.team赋值给team进行一次空操作 ,后续可进行优化

            System.out.println("--------------------------团队成员列表--------------------------");
            System.out.println("TDI/ID\t姓名\t\t年龄\t  工资\t\t职位\t\t奖金\t\t  股票");
            for (int i = 0; i < teamSvc.getTeam().length; i++) {
                String str = teamSvc.getTeam()[i].getMemberId() + "  / " + teamSvc.getTeam()[i].toString();
                if (teamSvc.getTeam()[i] instanceof Architect) {
                    str = teamSvc.getTeam()[i].getMemberId() + "  / " + teamSvc.getTeam()[i] + "\t" + teamSvc.getTeam()[i].toString3();
                }
                if (teamSvc.getTeam()[i] instanceof Designer) {
                    str = teamSvc.getTeam()[i].getMemberId() + "  / " + teamSvc.getTeam()[i] + "\t" + teamSvc.getTeam()[i].toString3();
                }
                System.out.println(str);
            }
            System.out.println("--------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            TSUtility.readReturn();
        }

    }

    //实现添加成员的操作
    private void addMember() {      //后续需要写一个finally执行按空格以继续操作
        try {
            System.out.println("\n\n-------------------添加团队成员-------------------");
            System.out.print("请输入要添加的员工的ID：");
            int ID = scan.nextInt();
            teamSvc.addMember(listSvc.getEmployees(ID));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TSUtility.readReturn();
        }
    }

    //实现删除成员的操作
    private void deleteMember() {
       try{
           System.out.println("\n\n-------------------删除团队成员-------------------");
           System.out.print("请输入要删除的员工ID：");
           int MID = scan.nextInt();
           teamSvc.removeMember(MID);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }finally {
           TSUtility.readReturn();
       }
    }

}
