package day02.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-18 22:38
 * @description: 练习一：银行有一个账户存3000元，每次存1000，存3次，每次存完都打印账户余额
 * <p>
 *                     问题：该线程是否有安全问题，如果有，该如何解决
 *                     答：该问题有线程安全问题，有三种方法进行解决：
 *                     ①用synchronized的同步代码块方式解决
 *                     ②用synchronized的同步方法方式进行解决
 *                     ③用lock锁手动启动手动终止进行解决
 **/

class Bank implements Runnable {

    private int money = 0;

    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {

        while (true) {
            try {
                lock.lock();
                if (money < 3000) {
                    money += 1000;
                    System.out.println(Thread.currentThread().getName() + " " + money);
                }else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class Bank_Test {
    public static void main(String[] args) {

        Bank bank = new Bank();
        show(new Thread(bank),"储户1");
        show(new Thread(bank),"储户2");
    }

    public static void show(Thread t,String name){
        t.setName(name);
        t.start();
    }
}

