package day01;

/**
 * Created by FangYan on 2019/4/10.
 */
public class QuickSearch {

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int key=a[r];
        int i=p;
        for(int j=p;j<r;j++){
            if(a[j]<key){
                if(i!=j){
                    int tem=  a[i];
                    a[i]=a[j];
                    a[j]=tem;
                }
                i++;
            }
        }
        int tem=a[i];
        a[i]= a[r];
        a[r]= tem;
        return i;
    }

    public static void main(String[] args) {
        int a[] = {1, 8, 4, 2, 6, 7, 9, 5};
        quickSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}