package day02;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-18 17:45
 * @description: 使用同步方法解决Runnable接口的线程安全问题
 *
 *               关于同步方法的总结：
 *                1，同步方法仍然涉及到同步监视器，只是不需要我们显式的赋值
 *                2，非静态的同步方法，同步监视器 this
 *                   静态的同步方法，同步监视器  当前类本身（当前类.class）
 **/

class Window3 implements Runnable {

    private int ticket = 1000;

    @Override
    public void run() {
        while (true) {

            show();
        }
    }

    //将操作共享数据的代码放入用synchronized修饰的方法中
    private synchronized void show() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {

        Window3 window1 = new Window3();
        Thread t1 = new Thread(window1);
        t1.setName("窗口1");
        t1.start();

        start(new Thread(window1), "窗口2");
        start(new Thread(window1), "窗口3");
    }

    public static void start(Thread t, String name) {
        t.setName(name);
        t.start();
    }
}