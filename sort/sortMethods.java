package zzy.leecode.sort;

import java.util.Arrays;

public class sortMethods {
    public static void main(String[] args) {
        int[] a = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36, 9};
//        bubbleSort(a,a.length);
//        selectSort(a,a.length);
//        reverseSort(a,a.length);
//        insertSort(a,a.length);

        System.out.println(Arrays.toString(a));
    }

    // 1、冒泡排序：一次比较两个元素，若两者顺序错误就进行交换
    private static void bubbleSort(int[] a, int n){
        if (n<=1) return; // 边界条件判断
        for (int i=1;i<n;i++){
            boolean flag = true;  // 提前退出冒泡循环的标志位，若有数据交换，则变为false
            for (int j=0;j<n-i;j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false; // 表示有数据交换
                }
            }
            if (flag) break; // 已经没有数据交换，说明排序结束，提前退出
        }
    }


    // 2、选择排序：先找到最小元素索引，然后将该元素与第一位上的元素进行交换
    private static void selectSort(int[] a, int n){
        if (n<=1) return;
        for (int i=0;i<n;i++){
            int index = i; // 从i开始的最小值索引
            for (int j=i;j<n;j++){
                if (a[j]<a[index])
                    index = j; // 更换最小值的索引
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }


    // 3、反转排序，时间复杂度O(n/2)
    private static void reverseSort(int[] a,int n){
        for (int i=0;i<n/2;i++){
            int temp = a[i];
            a[i] = a[n-1-i];
            a[n-1-i] = temp;
        }
    }

    // 4、插入排序：不断扩大范围，将index的数插入范围内，
    // 一直找到比index位置小的数，插入在小的数的右一位
    private static void insertSort(int[] a,int n){
        for (int i=1;i<n;i++){
            int insert = a[i]; // 被插入的数字
            int left = i-1;
            // 若左侧数大于插入数，不断向右侧移一位
            while (left>=0&&a[left]>insert){
                a[left+1] = a[left];
                left--;
            }
            a[left+1] = insert; //把insert放到空位上
        }
    }
}
