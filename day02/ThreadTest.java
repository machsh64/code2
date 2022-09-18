package day02;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-18 21:32
 * @description:     演示线程的死锁问题
 *
 *                1，死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，
 *                             都在等待对方放弃自己需要的同步资源，就形成了线程的死锁。
 *
 *                2，说明：
 *                  ①：出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 *                  ②：我们使用同步时，要避免出现死锁。
 **/
public class ThreadTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){                                   //③ 最终因为发生死锁，导致程序无法继续执行下去，但也不结束执行
            @Override
            public void run() {
                synchronized(s1) {

                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }                                    //① 此时该线程持有s1，但因为阻塞在等待获取s2

                    synchronized (s2) {

                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {

                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }                                    //② 此时该线程持有s2，但因为阻塞在等待获取s1


                    synchronized (s1) {

                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
