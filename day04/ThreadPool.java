package day04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-20 15:14
 * @description:   创建线程的方式四：使用线程池
 *
 *                 好处：1，提高相应速度(减少了创建新线程的时间)
 *                      2，降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *                      3，便于线程管理
 *                         corePoolSize：核心池大小
 *                         maximumPoolSize：最大线程数
 *                         keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *                 面试题： 创建多线程有几种方式：四种：继承Thread类， 实现Runnable接口，
 *                                               实现Callable接口， 使用线程池
 **/

class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1，提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
        service1.setCorePoolSize(15);  //设置线程池的大小
        /*service1.setKeepAliveTime();*/

        //2，执行指定的线程的操作。许哟啊提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());  //适用于Runnable
        service.execute(new NumberThread1()); //适用于Runnable
        /*service.submit();*/  //适用于Callable
        //3，关闭连接池
        service.shutdown();

    }
}
