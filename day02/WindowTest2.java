package day02;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-17 22:26
 * @description: 例子：创建三个窗口卖票，总票数为100张  继承Thread类的方式
 *
 *               使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 *               说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，可以考虑使用当前类充当同步监视器
 *
 **/

class Window2 extends Thread {

    private static int ticket = 1000;
    private static final Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized(Window2.class){
                if (ticket > 0) {

                 /** try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                    System.out.println(getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }

    public Window2(String name){
        super(name);
    }
}

public class WindowTest2 {
    public static void main(String[] args) {

        start(new Window2("窗口1"));
        start(new Window2("窗口2"));
        start(new Window2("窗口3"));
    }

    public static void start(Window2 t){
        t.start();
    }
}
