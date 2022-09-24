package project.TeamSchedule.domain;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:53
 * @description: 电脑的子类
 **/
public class PC implements Equipment {

    private String model;    //机器的型号
    private String disPlay;    //显示器名称

    public PC(String model, String disPlay) {
        this.model = model;
        this.disPlay = disPlay;
    }

    /**
     * @Param: 实现接口重写抽象方法
     * @Author: Ren
     * @return: 机器型号（显示屏型号）
     * @Date: 2022/9/13 17:15
     */
    @Override
    public String getDescription() {
        return model + "(" + disPlay + ")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisPlay() {
        return disPlay;
    }

    public void setDisPlay(String disPlay) {
        this.disPlay = disPlay;
    }
}
