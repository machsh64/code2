package project.TeamSchedule.service;

import project.TeamSchedule.domain.*;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:38
 * @description: 公司成员类
 **/
public class NameListService {

    private Employee[] employees;

    //在NameListService中将Data类中的值赋给Employee数组
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < Data.EMPLOYEES.length; i++) {
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            double bonus;
            int stock;
            Equipment eq;

            switch (Data.EMPLOYEES[i][0]) {
                case "10":
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case "11":
                    eq = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case "12":
                    eq = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, eq, bonus);
                    break;
                default:
                    eq = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int index) {
        switch (Data.EQUIPMENTS[index][0]) {
            case "21":
                return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
            case "22":
                int price = Integer.parseInt(Data.EQUIPMENTS[index][2]);
                return new NoteBook(Data.EQUIPMENTS[index][1], price);
            case "23":
                return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
        }
        return null;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployees(int id) throws RuntimeException {
        if (employees[id - 1] != null)
            return employees[id - 1];
        else throw new TeamException("添加失败，原因：该员工不存在");
    }

}
