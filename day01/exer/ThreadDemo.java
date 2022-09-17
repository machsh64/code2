package day01.exer;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-17 14:36
 * @description: 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 **/

//偶数的线程
class Even extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

//奇数的线程
class Odd extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        //匿名对象更加遍历快速调用
        start(new Even());
        start(new Odd());

        //创建Thread类的匿名子类的方式  //直接通过Thread的 匿名子类 匿名对象.start() 实现多线程
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 创建Thread匿名子类的方式");
            }
        }.start();
    }

    public static void start(Thread t) {
        t.start();
    }
}
