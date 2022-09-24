package project.TeamSchedule.domain;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:53
 * @description:  架构师
 **/
public class Architect extends project.TeamSchedule.domain.Designer {

    private int stock;     //公司奖励的股票数量

    public Architect(int id,String name,int age,double salary,Equipment equipment,double bonus,int stock){
        super(id, name, age, salary,equipment,bonus);
        this.stock = stock;
        setWork("架构师");
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString3() {
        return super.toString3()+"\t  "+getStock();
    }

    @Override
    public String toString1() {
        return super.toString1()+"\t  "+getStock();
    }
}
