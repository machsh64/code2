package LeetCode;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-21 21:35
 * @description:
 **/
public class Q0LinkNode {
    public static void main(String[] args) {
    /*    MyList list = new MyList();
        list.add(7);
        list.add(8);
        list.add(9);

        MyList.print();*/
    }
}

/*
class MyList {

    class ListNode{
        public int val ; // 节点的保存的内容
        public ListNode next = null;  //节点的引用，指向下一节点
        public ListNode(int val)
        {
            this.val = val;
        }
    }

    private ListNode head = null; //头节点


    public boolean add(int a) {  //添加新节点
        ListNode newNode = new ListNode(a);//实例化一个新节点a
        if (head == null) { //若头节点为空，新节点赋值给头节点
            head = newNode;
            return true;
        }
        ListNode cur = head;  //若头节点不为空，用cur代替head进行操作。防止修改head的值
        while (cur.next != null) { //遍历到最后一个节点
            cur = cur.next;
        }
        cur.next = newNode ; //让上一个节点的next指向新节点，完成连接
        return true;
    }

    public boolean delete(int a){ //删除指定节点
        if(head == null){  //若头节点为空，返回false
            return false;
        }
        if(head.val == a){
            head = head.next;
            return true;
        }
        ListNode cur = head; //用cur代替head进行操作。防止修改head的值（以下不再解释）
        while (cur.next != null){ //遍历所有节点
            if(cur.next.val == a){//对cur.next节点进行判断，如果是要删除的，直接让cur.next指向被删除节点的next节点。即为：cur.next = cur.next.next;
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int size(){  //返回节点长度
        int flag = 0;
        ListNode cur = head;
        while(cur != null){
            flag++;
            cur =cur.next;
        }
        return flag;
    }

    public int find(int a){  //查找节点，返回下标
        ListNode cur = head;
        int flag = 0;
        while(cur.next != null){
            if(cur.val != a){
                flag++;
                cur = cur.next;
            }
            return flag;
        }
        return -1;
    }

    public ListNode get(int x){ //用下标查找节点
        if(head == null){
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < x; i++) {
            cur = cur.next;
        }
        return cur;
    }

     public static void print(ListNode listNode){
        //创建链表节点
        while(listNode!=null){
            System.out.println("节点:"+listNode.val);
            listNode=listNode.next;
        }
        System.out.println();
    }
}
*/

