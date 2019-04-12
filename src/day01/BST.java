package day01;

/**
 * Created by FangYan on 2019/4/10.
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }

    }

    private int size;
    private Node root;

    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            node = new Node(e);
            size++;
            return node;
        }
        Node tmp = node;
        while (tmp!=null){
           if(e.compareTo(tmp.e)<0){
               //左节点
               if(tmp.left==null){
                   tmp.left = new Node(e);
                   size++;
                   return node;
               }
               tmp=tmp.left;
           }
           else if(e.compareTo(tmp.e)>0){
               //右节点
               if(tmp.right==null){
                   tmp.right = new Node(e);
                   size++;
               }
               tmp=tmp.right;
           }else {
               return node;
           }
       }
       return node;
    }

    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.e);
        inorder(root.right);
    }



    public int depth(Node root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left)+1;
        int right = depth(root.right)+1;
        return left>right?left:right;
    }

    /*
     * 层序遍历
     * 递归
     */
    public void levelOrder(Node node) {
        if (node == null) {
            return;
        }
        int depth = depth(node);
        for (int i = 1; i <= depth; i++) {
            levelOrder(node, i);
        }
    }

    private void levelOrder(Node node, int level) {
        if (node == null || level < 1) {
            return;
        }
        if (level == 1) {
            System.out.print(node.e + "  ");
            return;
        }
        // 左子树
        levelOrder(node.left, level - 1);
        // 右子树
        levelOrder(node.right, level - 1);
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        int[] arr = new int[]{18, 12, 12, 12, 12, 7, 3, 4, 8, 16, 13, 17, 14, 30, 20, 32, 50, 40};
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        System.out.println("开始打印");
        bst.levelOrder(bst.root);
        System.out.println("最大深度为："+bst.depth(bst.root));
    }
}
