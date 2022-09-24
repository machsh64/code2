package project.TeamSchedule.domain;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:53
 * @description: 笔记本
 **/
public class NoteBook implements Equipment {

    private String model;   //  笔记本型号
    private int price;   //  笔记本价格

    public NoteBook(String model, int price) {
        this.model = model;
        this.price = price;
    }

    /**
     * @Param: 实现接口重写抽象方法
     * @Author: Ren
     * @return: 笔记本型号（笔记本价格）
     * @Date: 2022/9/13 17:15
     */
    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
