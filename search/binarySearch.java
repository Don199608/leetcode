package zzy.leecode.search;

public class binarySearch {

    public static void main(String[] args) {
        int[] test_arr = {8, 9, 12, 18, 28, 36, 50, 65, 73, 89, 96};
        System.out.println(binarySearch(test_arr,12));
        System.out.println(binarySearch1(test_arr,12));
    }

    // 二分法的非递归实现
    public static int binarySearch(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while (low<= high){
            int mid = low+((high -low)>>1);
            if (arr[mid]==target)
                return mid;
            else if (arr[mid]>target)
                high = mid-1;
            else if (arr[mid]<target)
                low = mid+1;
        }
        return -1;
    }

    // 二分法的递归实现
    public static int binarySearch1(int[] arr,int target){
        return mybinarySearch1(arr,0,arr.length-1,target);
    }
    public static int mybinarySearch1(int[] arr,int low,int high,int target){
        if (low>high)
            return -1;
        int mid = low + ((high-low)>>1);
        if (arr[mid]==target)
            return mid;
        else if (arr[mid]>target)
            return mybinarySearch1(arr,low,mid-1,target);
        // 此处不能用else if，否则编译器会判定不一定有返回值
        else
            return mybinarySearch1(arr,mid+1,high,target);
    }

    // 二分查找变形：查找第一个值等于给定值的元素
    public static int binarySearch2(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while (low<= high){
            int mid = low+((high -low)>>1);
            if (arr[mid]>target)
                high = mid-1;
            else if (arr[mid]<target)
                low = mid+1;
            else {
                if ((mid==0)||arr[mid-1]!=target)
                    return mid;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

    // 二分查找变形：查找最后一个值等于给定值的元素
    public static int binarySearch3(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while (low<= high){
            int mid = low+((high -low)>>1);
            if (arr[mid]>target)
                high = mid-1;
            else if (arr[mid]<target)
                low = mid+1;
            else {
                if ((mid==arr.length-1)||arr[mid+1]!=target)
                    return mid;
                else
                    low = mid+1;
            }
        }
        return -1;
    }

    // 二分查找变形：查找第一个大于等于给定值的元素
    public static int binarySearch4(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = low+((high -low)>>1);
            if (arr[mid] >= target){
                if ((mid==0)||(arr[mid-1]<target))
                    return mid;
                else high = mid-1;
            }
            else
                low = mid+1;
        }
        return -1;
    }

    // 二分查找变形：查找最后一个小于等于给定值的元素
    public static int binarySearch5(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = low+((high -low)>>1);
            if (arr[mid] <= target){
                if ((mid==arr.length-1)||(arr[mid+1]>target))
                    return mid;
                else low = mid+1;
            }
            else
                high = mid-1;
        }
        return -1;
    }
}
