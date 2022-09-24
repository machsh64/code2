package project.TeamSchedule.domain;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:52
 * @description:   设计师
 **/
public class Designer extends Programmer {

    private double bonus;   //奖金

    public Designer(int id,String name,int age,double salary,Equipment equipment,double bonus){
        super(id, name, age, salary,equipment);
        this.bonus = bonus;
        setWork("设计师");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString3() {
        return ""+getBonus();
    }

    @Override
    public String toString1() {
        return super.toString1()+""+ getBonus();
    }
}
