package zzy.leecode.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 分治思想，递归技巧
 * */
public class quickSort {
    public static void main(String[] args) {
        int[] a = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36, 9};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr){
        myQuickSort(arr,0,arr.length-1);
    }
    public static void myQuickSort(int[] arr, int l, int r){
        // 递归中止条件
        if (l>=r)
            return;

        int q = partition(arr,l,r); // 获取分区点index，前部分小于分区点，后部分大于分区点
        myQuickSort(arr,l,q-1);
        myQuickSort(arr,q+1,r);
    }

    // 原地分区过程
    public static int partition(int[] arr, int l, int r){
        int privot = arr[r]; // 取数组最后一个元素作为分区点
        int i = l;
        for (int j = l;j<=r;j++){
            if (arr[j]<privot){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i++] = temp;
            }
        }
        int temp = arr[r];
        arr[r] = arr[i];
        arr[i] = temp;
        return i;
    }
}
