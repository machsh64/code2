package day03;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-20 10:11
 * @description: 线程通信的应用：经典例题：生产者/消费者问题
 *
 *               ●生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 *                 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
 *                 如果店中有空位放产品了再通知生产者继续生产:如果店中没有产品了，店员会告诉消费者等一下，
 *                 如果店中有产品了再通知消费者来取走产品。
 *               ●这里可能出现两个问题:
 *                  >生产者比消费者快时，消费者会漏掉一些数据没有取到。
 *                  >消费者比生产者快时，消费者会取相同的数据。
 *
 **/
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Customer customer = new Customer(clerk);

        show(new Thread(producer),"生产者1");
        show(new Thread(customer),"消费者1");
        show(new Thread(customer),"消费者2");

    }

    public static void show(Thread t, String name){
        t.setName(name);
        t.start();
    }
}

//店员
class Clerk {
    private int produceNo = 0;
    public static int times = 0;

    //生产产品
    public synchronized void produce() {
        if (produceNo < 20) {
            produceNo++;
            System.out.println(Thread.currentThread().getName() + " 开始生产第 " + produceNo + " 个产品");
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consume() {
        if (produceNo > 0) {
            System.out.println(Thread.currentThread().getName() + " 开始消费第 " + produceNo + " 个产品");
            produceNo--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//生产者
class Producer implements Runnable {
    private final Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始生产......");
        while(true){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
            Clerk.times++;

            //使生产者生产100次以后停止生产
            if (Clerk.times > 100){
                return;
            }
        }
    }
}

//消费者
class Customer implements Runnable {
    private final Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始消费......");
        while(true) {
            try {
                Thread.sleep(110);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();

            //使生产者生产100次以后停止消费
            if (Clerk.times > 100){
                return;
            }
        }
    }
}
