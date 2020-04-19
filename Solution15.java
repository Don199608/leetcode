package zzy.leecode;

import java.util.*;

/**
 * 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * */
public class Solution15 {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>(); // 返回List
//        Map<Integer, Integer> map = new HashMap();   // 用于一次Hash查表
//        /* 边界判断 */
//        if (nums==null||nums.length<3)
//            return res;
//        Arrays.sort(nums);
//        int len = nums.length;
//        for (int i=0;i<len-2;i++){
//            // 若最小值大于0，则中止循环
//            int min1 = nums[i]+nums[i+1]+nums[i+2];
//            if (min1>0)
//                break;
//            // 若最大值小于0，则跳过本次循环
//            int max1 = nums[i]+nums[len-1]+nums[len-2];
//            if (max1<0)
//                continue;
//            // 确定一个值问题变成两数之和，进行Hash一次查表
//            for (int j=i+1;j<len-1;j++){
//                // 若最小值大于0，则中止循环
//                int min2 = nums[j]+nums[i+1];
//                if (min1>-nums[i])
//                    break;
//                // 若最大值小于0，则跳过本次循环
//                int max2 = nums[j]+nums[len-1];
//                if (max1<-nums[i])
//                    continue;
//                int target = -nums[i]-nums[j];
//                if (map.containsKey(target))
//                    res.add(Arrays.asList(nums[i],nums[j],nums[map.get(target)]));
//                map.put(nums[j],j);
//            }
//        }
//        return res;
//    }
}
