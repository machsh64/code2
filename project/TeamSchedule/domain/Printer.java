package project.TeamSchedule.domain;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:54
 * @description: 打印机
 **/
public class Printer implements Equipment {

    private String name;   //打印机名字
    private String type;   //打印机类型

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * @Param: 实现接口重写抽象方法
     * @Author: Ren
     * @return: 机器型号（打印机型号）
     * @Date: 2022/9/13 17:15
     */
    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
