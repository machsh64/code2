package day01;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-17 19:47
 * @description: 测试Thread中的常用方法：
 *               1. start()：启动当前线程；调用当前线程的run()
 *               2. run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 *               3. currentThread()：静态方法，返回执行当前代码的线程
 *               4. getName()：获取当前线程的名字
 *               5. setName()：设置当前线程的名字
 *               6. yield()：释放当前CPU的执行权，但下次执行仍有可能是本线程执行
 *               7. join()：在线程a 中调用线程b 的join()方法，此时线程a 就进入阻塞状态，直到线程b 完全执行完以后，线程a 才结束阻塞状态
 *               8. stop()：方法已经过时，当执行此方法时强制结束当前线程
 *               9. sleep(long millitime)：让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程为阻塞状态
 *               10. isAlive()：判断当前线程是否存活
 *
 *
 *               线程的优先级：
 *               1.
 *               MAX_PRIORITY: 10
 *               MIN_PRIORITY: 1
 *               NORM_PRIORITY: 5
 *               2.如何获取和设置当前线程的优先级
 *                 getPriority(): 获取线程的优先级
 *                 setPriority(int p): 设置线程的优先级
 *
 *                 说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率学上讲，
 *                      高优先级的线程高概率的情况下会优先被执行，并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 *
 **/

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                /*try {
                    //sleep(String millitime);  使当前线程进入设定时间的睡眠状态
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName() + " "+ Thread.currentThread().getPriority() +": "+ i);
            }
            /*if (i % 20 == 0){
                //yield();    释放当前CPU执行权，但下次执行仍有可能是当前线程执行
                 Thread.yield();
            }*/
        }
    }

    public HelloThread(String name) {
        super(name);
    }
}

public class ThreadMyThreadTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("线程一");
        // h1.setName("我是线程一");
        //setPriority(int p);设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() +" "+ Thread.currentThread().getPriority() +": "+ i);
            }
        /*    if (i == 20) {
                try {
                    //xx.join();   当主线程满足条件时，进入阻塞状态，直至h1线程执行完在继续执行
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        }
        //xx.isAlive();   显示h1线程的是否继续存在
        //System.out.println(h1.isAlive());
    }
}
