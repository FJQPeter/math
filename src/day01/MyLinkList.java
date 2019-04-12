package day01;

/**
 * Created by FangYan on 2019/4/1.
 * 使用内部类的最大好处是可以和外部类进行私有操作的互相访问,实现多继承
 */
public class MyLinkList<E extends Comparable<E>> {
    private class Node{
        private E data;
        private Node next;
        public Node(E data) {
            this.data = data;
        }
    }

    private int size;

    private Node dummyHead;

    public MyLinkList() {
        this.dummyHead = new Node(null);
        size = 0;
    }

    /**
     * 添加
     * @param data
     * @param index
     */
    public void add(E data,int index){
        if (index < 0 || index >size){
            throw new IllegalArgumentException("非法index");
        }
        Node head = dummyHead;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
            Node node = new Node(data);
            node.next = head.next;
            head.next = node;
            size++;
    }

    /**
     * 删除
     * @param head
     * @param data
     * @return
     */
    private Node remove(Node head,E data){
        if(head==null){
            return null;
        }
        Node result = remove(head.next,data);
        if(head.data==data){
            size--;
            return result;
        }else {
            head.next = result;
            return head;
        }
    }

    public void remove(E data){
        remove(this.dummyHead.next,data);
    }

    public void reverse(){
        dummyHead.next = reverse(this.dummyHead.next);
    }

    /**
     * 判断是否有环
     * @param node
     * @return
     */
    public boolean isCycle(Node node){
        if(node==null){
            return false;
        }
        Node fast = node.next;
        Node slow = node;
        while (fast!=null&&fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if(slow==fast){
                    return true;
                }
        }
        return false;
    }

    /**
     * 找出环的入口点
     * 慢指针走的路程等于环的个数，所以慢指针距离环的入口和起点距离入口的距离一样
     */
    public Node EntryNodeOfLoop2(Node pHead){
        Node fast = pHead;
        Node slow = pHead;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //当快指针 与 慢指针相遇时
            if(fast == slow){
                fast = pHead;
                //再次相遇
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    public void print(){
        Node head = dummyHead;
        while ((head=head.next)!=null){
            System.out.print(head.data+"-->");
        }
    }

    public void printK(int index){
        reverse();
        Node head = dummyHead;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        System.out.println(head.data);
    }

    /**
     * 链表反转
     * @param node
     * @return
     */
    private Node reverse(Node node){
        if(node==null||node.next==null){
            return node;
        }else {
            Node newHead = reverse(node.next);
            node.next.next = node;
            node.next=null;
            return newHead;
        }
    }

    Node merge(Node node1,Node node2){
        if(node1==null){
            return null;
        }else if(node2==null){
            return node1;
        }
        Node merge;
        if(node1.data.compareTo(node2.data)<0){
                merge = node1;
                merge.next = merge(node1.next,node2);
        }else {
                merge = node2;
                merge.next = merge(node2.next,node1);
        }
                return merge;
    }


    public static void main(String[] args) {
        MyLinkList<Integer> linkList = new MyLinkList<>();
        linkList.add(1,0);
        linkList.add(4,1);
        linkList.add(8,2);
        linkList.add(10,3);
        linkList.add(12,4);
        MyLinkList<Integer> linkList2 = new MyLinkList<>();
        linkList2.add(3,0);
        linkList2.add(5,1);
        linkList2.add(6,2);
        linkList2.add(9,3);
        linkList2.add(11,4);
        linkList.merge(linkList.dummyHead.next,linkList2.dummyHead.next);
        linkList.print();
//        linkList.remove(8);
//        linkList.print();
    }
}
