package day04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-20 11:51
 * @description:   创建线程的方式三：实现Callable接口。 ----JDK5.0新增
 *
 *
 *                如何理解Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 *                1，call()可以有返回值
 *                2，call()可以抛出异常，被外面的操作捕获，获取异常的信息
 *                3，Callable是支持泛型的
 *
 **/

//1，创建一个实现Callable接口的实现类
class NumThread implements Callable{

    ReentrantLock lock = new ReentrantLock(true);

    //2，实现call方法，将需要做的操作声明 在call中
    @Override
    public Object call() throws Exception {
        int sum = 0;

        try{
            lock.lock();
            for(int i = 0; i < 100; i++){
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+"  " + i);
                    sum += i;
                }
            }return sum;
        }finally {
            lock.unlock();
        }
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3，创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4，将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5，将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        Thread t = new Thread(futureTask);
        t.setName("线程1");
        t.start();

        try {
            //6，获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object num = futureTask.get();
            System.out.println("总和为：" + num);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
