package day09;


/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-24 19:30
 * @description:
 *
 * 三，Enum类中的常用方法：
 *    values()方法：返回枚举类型的对象数组。该方法可以很方便的遍历所有的枚举类
 *    valueOf(String str)：可以把一个字符串转为对应的枚举类对象，要求字符串必须是枚举类的对象
 *    toString()：返回当前枚举类对象常量的名称
 * 四：使用enum关键字定义的枚举类实现接口的情况
 *    情况一：实现接口，在enum类中实现抽象方法
 *    情况二：让枚举类的对象分别实现接口中的抽象方法
 *
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.enum类
 **/
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        //toString()方法
        System.out.println(spring.toString());

        //values()方法
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].toString());
        }

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String ObjName)：返回枚举类中对象名是objName的对象。
        //如果没有objName的枚举类对象，则抛异常：java.lang.IllegalArgumentException
        /*Season1 weather = Season1.valueOf("WINTER1");*/
        Season1 weather = Season1.valueOf("WINTER");
        System.out.println(weather);
        weather.show();
    }
}

//使用enum关键字
enum Season1 implements Info {
    //1，提供当前枚举类的多个对象，多个对象之间用“,”隔开，末尾对象“;”结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "烈日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天悄悄来临");
        }
    },
    AUTUMN("秋天", "瓜果飘香"){
        @Override
        public void show() {
            System.out.println("秋天一去不归来");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2，声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    //2，私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4，其他诉求1：获取枚举类的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4，其他诉求2：提供toString
/*    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/

    @Override
    public void show() {
        System.out.println("这是一个季节（继承了Info接口实现的抽象方法重写");
    }
}

interface Info {
    public abstract void show();
}
