package day03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-20 09:22
 * @description: 线程通信的例子：使用两个线程打印1-100.线程1，线程2 交替打印
 *
 *               涉及到的三个方法：
 *               1，wait()：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 *               2，notify()：一旦执行此方法，就会唤醒wait()的一个线程，如果有多个线程wait，就唤醒优先级高的线程
 *               3，notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程
 *
 *               说明：
 *               1，wait(),notify(),notifyAll() 三个方法必须使用在同步代码块或同步方法当中
 *               2，wait(),notify(),notifyAll() 三个方法的调用者必须是同步代码块或同步方法中的同步代码块
 *               3，wait(),notify(),notifyAll() 三个方法是定义在java.lang.Object类中的
 *
 *               面试题：sleep() 和 wait() 的异同？
 *                 1，相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 *                 2，不同点：① 两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *                          ② 调用的要求不同：sleep() 可以在任何需要的场景下调用，wait() 必须在同步代码或同步方法中调用
 *                          ③ 关于是否释放同步监视器：如果两个方法都是用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
 **/

class Number implements Runnable {
    private int number = 0;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized(obj) {

                obj.notify();
                if (number < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + (++number));

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number num = new Number();

        show(new Thread(num), "线程1");
        show(new Thread(num), "线程2");
    }

    public static void show(Thread t, String name) {
        t.setName(name);
        t.start();
    }
}
