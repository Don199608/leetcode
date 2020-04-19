package zzy.leecode.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 使用分治的思想，用递归的技巧
 * */
public class mergeSort {
    public static void main(String[] args) {
        int[] a = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36, 9};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] arr){
        myMergeSort(arr,0,arr.length-1);
    }
    // 递归方法
    public static void myMergeSort(int[] arr, int l, int r){
        // 递归中止条件
        if (l>=r)
            return;
        // q为中间位置
        int q = l + ((r-l)>>1);
        myMergeSort(arr,l,q);
        myMergeSort(arr,q+1,r);
        merge(arr,l,q,r);
    }
    // 将两个排序好的数组顺序合并
    public static void merge(int[] arr,int l, int q, int r){
        int[] temp = new int[r - l + 1]; // 用于临时存放排序后元素的数组
        int i = 0; // i表示temp里放入多少个元素
        int p1 = l; // 分别表示两个排序好的数组的head index
        int p2 = q + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= q && p2 <= r) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= q) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= r) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
    }
}
