package day02;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-18 18:11
 * @description: 使用同步机制将单例模式懒汉式改写为线程安全的
 **/
public class BankTest {

}

class Bank {

    private Bank() {

    }

    private static Bank instance = null;

    public static Bank getInstance() {
        //方式一：效率稍差
      /**synchronized (Bank.class){

         if (instance == null) {
         instance = new Bank();
         }
         return instance;
         }*/
        //方式二： 效率稍高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {

                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
