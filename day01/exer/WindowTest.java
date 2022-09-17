package day01.exer;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-17 22:26
 * @description: 例子：创建三个窗口卖票，总票数为100张  继承Thread类的方式
 **/

class Window extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ": 卖票，票号为：" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }

    public Window(String name){
        super(name);
    }
}

public class WindowTest {
    public static void main(String[] args) {

        start(new Window("窗口一"));
        start(new Window("窗口二"));
        start(new Window("窗口三"));
    }

    public static void start(Window t){
        t.start();
    }
}
