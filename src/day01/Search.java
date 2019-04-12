package day01;

/**
 * Created by FangYan on 2019/4/10.
 */
public class Search {
    public static void main(String[] args) {
        int[] arr = {3,8,6,35,66,84,99,108};
        int sort = sort(arr, 84, 0, 7);
        System.out.println(sort);
    }

    public static int sort(int []array,int a,int lo,int hi){
        if(lo<hi){
            int mid=(lo+hi)/2;
            System.out.println("中间值"+mid);
            if(a==array[mid]){
                return mid;
            }
            else if(a>array[mid]){
                return sort(array,a,mid,hi);
            }else{
                return sort(array,a,lo,mid);
            }
        }
        return -1;
    }
}
