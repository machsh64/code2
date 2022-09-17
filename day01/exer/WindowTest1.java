package day01.exer;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-17 23:27
 * @description: 例子：创建三个窗口卖票，总票数为100张   实现Runnable接口的方式来做
 **/

class Window1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
            System.out.println(Thread.currentThread().getName()+": 卖票，票号为：" + ticket);
            ticket--;
            }else {
                break;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {

        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        t1.setName("窗口1");
        t1.start();

        start(new Thread(window1),"窗口2");
        start(new Thread(window1),"窗口3");
    }

    public static void start(Thread t,String name){
        t.setName(name);
        t.start();
    }
}
