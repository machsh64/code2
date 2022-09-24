package day08;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-24 16:41
 * @description:
 **/
public class Goods implements Comparable {
    private String name;
    private int price;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //知名商品比较大小的方式：先按照价格从低到高排序，在按照产品名称从低到高排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            //方式一：
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                return this.name.compareTo(goods.name);   //从字符排序，从低到高
            }
            //方式二：
            /*return Double.compare(this.price,goods.price);*/
        }
        throw new RuntimeException("传入的数据异常");
    }
}
