package day02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-18 22:07
 * @description:      解决线程安全问题的方式三：Lock锁   ---jdk5.0新增
 *
 *                  1，面试题：synchronized 与 lock 的异同
 *                    相同：二者都可以解决线程安全问题
 *                    不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *                         lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 **/

class Window implements Runnable {

    private static int ticket = 100;

    //1，实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try{

                //调用锁定方法lock()
                lock.lock();
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally {
                //3，调用解锁方法unLock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window win = new Window();

        show(new Thread(win), "窗口1");
        show(new Thread(win), "窗口2");
        show(new Thread(win), "窗口3");
    }

    public static void show(Thread t, String name) {
        t.setName(name);
        t.start();
    }
}
