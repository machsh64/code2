package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-10-01 13:40
 * @description:
 **/
public class Order<T> {
    String orderName;
    int orderId;
    //类的内部结构就可以使用类的泛型
    T OrderT;

    public Order(){

    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        OrderT = orderT;
    }

    public T getOrderT() {
        return OrderT;
    }

    public void setOrderT(T orderT) {
        OrderT = orderT;
    }

    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

      /*  for (E e : arr) {
            list.add(e);
        }*/

        list.addAll(Arrays.asList(arr));
        return list;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", OrderT=" + OrderT +
                '}';
    }
}
