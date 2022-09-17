package day01;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-17 13:52
 * @description:    多线程的创建，方式一：继承于Thread类
 *                     1，创建一个继承于Thread类的子类
 *                     2，重写Thread类的run()
 *                     3，创建Thread类的子类的对象
 *                     4，通过此对象调用start()
 *
 *               例子: 遍历100以内的所有的偶数
 **/

// 1, 创建一个继承于Thread类的子类         //********创建的第一条线程
class MyThread extends Thread {

    // 2, 重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+ "  " + i);
            }
        }
    }
}

// 1, 创建一个继承于Thread类的子类          //********新创建的第二条线程
class MyThread2 extends Thread {

    // 2, 重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println(Thread.currentThread().getName()+ "  " + i);
            }

        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {

        //第一条线程
        //3, 创建Thread类子类的对象
        MyThread t1 = new MyThread();

        //4, 通过此对象调用start(): ① 启动当前线程 ② 调用当前线程的run()
        t1.start();
        //问题一：我们不能通过直接调用run()方法的方式启动线程
        //t1.run();   //此方法并未启动新线程，仍然在main线程当中运行

        //问题二：同一个线程只能调用一次，否则会调IllegalThreadStateException
        //t1.start();

        //main线程
     /*   //如下操作仍然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+ "" + i +"*");
            }
        }*/

        //第二条线程
        MyThread2 t2 = new MyThread2();

        t2.start();
    }
}
