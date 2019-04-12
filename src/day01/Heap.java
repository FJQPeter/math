package day01;

/**
 * Created by FangYan on 2019/4/11.
 */
public class Heap {
    private int[] a; // 数组，从下标 1 开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            return; // 堆满了
        }
        ++count;
        a[count] = data;
        int i = count;
        //i!=1
        while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
            swap(a, i, i/2); // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
            //选择新的根
            i = i/2;
        }
    }

    void swap(int arr[],int a,int b){
        int tmp = arr[a];
        arr[a]  = arr[b];
        arr[b]  = tmp;
    }
}

