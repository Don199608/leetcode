package zzy.leecode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Solution496 {
    // 1、自写，数组遍历法
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length];
        for (int i=0;i<nums1.length;i++){
            int j = 0;
            while (nums1[i]!=nums2[j])
                j++;
            ints[i] = -1;
            while (j++ < nums2.length-1){
                if (nums1[i]<nums2[j]){
                    ints[i] = nums2[j];
                    break;
                }
            }
        }
        return ints;
    }

    // 2、单调栈
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[nums1.length];
        // 将nums2放入顺序栈中，若弹出，则将映射对放入map中
        for (int i=0;i<nums2.length;i++){
            while (!stack.empty()&&stack.peek()<nums2[i]){
                hashMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty())
            hashMap.put(stack.pop(), -1);
        // 从map中获得映射关系
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }
}
