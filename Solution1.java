package zzy.leecode;
/**
1. 两数之和
    给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
*/

//方法一：暴力实现
//public class Solution1{
//    public int[] twoSum(int[] nums, int target) {
//        int[] results = new int[2];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int sum = nums[i] + nums[j];
//                if (sum == target) {
//                    results[0] = i;
//                    results[1] = j;
//                    break;
//                }
//            }
//        }
//        return results;
//    }
//    public static void main(String[] args) {
//        Solution1 solution1 = new Solution1();
//        int[] x = {1,2,3,4};
//        int[] y ;
//        int z =3;
//        y = solution1.twoSum(x,z);
//        for(int m:y)System.out.println(m);
//    }
//}

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];     // 返回的结果数组
        Map<Integer, Integer> map = new HashMap(); // 哈希散列桶，包括数组和链表，存储键值对
        for (int i = 0; i < nums.length; i++) {
            int x = target-nums[i];
            if (map.containsKey(x)){    // 判断map是否存在x的key
                res[0] = i;
                res[1] = map.get(x);    // 返回x的val
            }
            map.put(nums[i],i);         // key:数组元素值 + value:数组index
        }
        return res;
    }
}























