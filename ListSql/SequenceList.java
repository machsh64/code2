package ListSql;

import java.util.Iterator;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-22 09:06
 * @description: 顺序表
 **/
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表的长度
    private int N;

    //构造方法
    public SequenceList(int capacity) {
        //初始化数组
        this.eles = (T[]) new Object[capacity];
        //初始化长度
        this.N = 0;
    }

    //将一个线性表设为空表
    public void clear() {
        this.N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return N == 0;
    }

    //获取线性表的长度
    public int length() {
        return N;
    }

    //获取指定位置的元素
    public T get(int i) {
        return eles[i];
    }

    //向线性表中添加元素t
    public void insert(T t) {
        //如果数组长度等于数组空间，则将数组扩容为原有的二倍
        if (N == eles.length) {
            resize(2 * eles.length);
        }
        eles[N++] = t;
    }

    //在i元素处插入元素t
    public void insert(T t, int i) {
        //如果数组长度等于数组空间，则将数组扩容为原有的二倍
        if (N == eles.length) {
            resize(2 * eles.length);
        }
        //先把i索引处的元素依次向后移一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index - 1];
        }
        //将索引处的元素替换为t
        eles[i] = t;

        //元素个数加1
        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i) {
        //记录i处的元素
        T current = eles[i];
        //将i之后的元素依次往前移一位
        for (int index = i; i < N - 1; i++) {
            eles[index] = eles[index + 1];
        }
        //元素个数-1
        N--;
        //如果数组长度小于数组空间的四分之一，则将数组压缩到原来的二分之一
        if (N < eles.length/4) {
            resize(eles.length/2);
        }
        return current;
    }

    //查找t元素第一次出现的位置
    public int indexOf(T t) {
        for (int index = 0; index < N; index++) {
            if (eles[index] == t) {
                return index;
            }
        }
        return -1;
    }

    //根据参数newSize，重置eles的大小
    public void resize(int newSize) {
        //定义一个临时数组，指向原数组
        T[] temp = eles;
        //创建新数组
        eles = (T[]) new Object[newSize];
        //把原数组的数据拷贝到新数组
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }

    }

    //遍历顺序表
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int cursor;

        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }

}
