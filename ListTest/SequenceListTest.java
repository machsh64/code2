package ListTest;

import ListSql.SequenceList;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-22 09:26
 * @description:  对ListSql中 SequenceList 的测试
 **/
public class SequenceListTest {
    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList <String> list = new SequenceList<>(2);
        //测试插入
        list.insert("科比");
        list.insert("姚明");
        list.insert("詹姆斯");
        list.insert("麦迪");
        list.insert("伦纳德",0);
        for(String s:list){
            System.out.println(s);
        }
        System.out.println("-------------------");
        for(int i = 0; i < list.length(); i++){
            System.out.println(list.toString());
        }
        System.out.println("-------------------");
        //测试获取
        String get0 = list.get(0);
        System.out.println("索引0处的元素是：" + get0) ;
        String get1 = list.get(1);
        System.out.println("索引1处的元素是：" + get1);
        //测试删除
        String remove3 = list.remove(3);
        System.out.println("删除后的元素是：" + remove3);
        //测试清空
        list.clear();
        System.out.println(list.length());

    }
}
