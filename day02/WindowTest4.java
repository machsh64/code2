package day02;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-18 17:55
 * @description:   使用同步方法解决继承Thead的线程安全问题
 **/

class Window4 extends Thread {

    private static int ticket = 1000;

    @Override
    public void run() {
        while (true) {

            show();
        }
    }

    private static synchronized void show(){  //同步监视器：Window4.class

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

    public Window4(String name){
        super(name);
    }
}

public class WindowTest4 {
    public static void main(String[] args) {

        start(new Window4("窗口一"));
        start(new Window4("窗口二"));
        start(new Window4("窗口三"));
    }

    public static void start(Window4 t){
        t.start();
    }
}
