package zzy.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

/**
 3. 无重复字符的最长子串
    给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
    就是子串中，每个字母都互不相等！
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
* */

public class Solution3 {
    //1、暴力法
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0; // 用于返回的最长子串长度
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j))
                    ans = Math.max(ans, j - i);     //返回最大长度
        return ans;
    }
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();             //set接口，无序排列，引入char字符
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);    //加入
        }
        return true;
    }

    //2、滑窗法
    public int lengthOfLongestSubstring2(String s) {
        if (s==null)
            return 0;
        int len = s.length(), ans = 1; // 最短重复子串长度为1
        Map<Character, Integer> map = new HashMap<>(); // key:String中的char + val:char index
        for (int start = 0, end = 0; end < len; end++) {
            char alpha = s.charAt(end);
            // 若出现重复字符，比对start和重复字符的最大索引，从重复字母的index+1作为窗口左边界
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha)+1, start);
            }
            ans = Math.max(ans,end-start+1); // 窗口最大值就是最长子串长度
            map.put(s.charAt(end), end); // 迭代跟新已出现字母的最大index，用于和前面的start比对
        }
        return ans;
    }
}