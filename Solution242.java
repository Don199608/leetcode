package zzy.leecode;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * */
public class Solution242 {
    // 排序思路：对两个字符串进行排序，直接equals

    // 1、sort排序
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    // 2、冒泡排序，超出时间限制
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        for (int i=1;i<s.length();i++){
            boolean flag = true;
            for (int j=0;j<s.length()-i;j++){
                if (str1[j]>str1[j+1]){
                    char temp = str1[j];
                    str1[j] = str1[j+1];
                    str1[j+1] = temp;
                    flag = false;
                }
                if (str2[j]>str2[j+1]){
                    char temp = str2[j];
                    str2[j] = str2[j+1];
                    str2[j+1] = temp;
                    flag = false;
                }
            }
            if (flag)
                break;
        }
        return Arrays.equals(str1, str2);
    }

    // 3、哈希查表法
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] sums = new int[26];
        for (int i=0;i<s.length();i++){
            sums[s.charAt(i) - 'a']++;
            sums[t.charAt(i) - 'a']--;
        }
        for (int sum:sums
             ) {
            if (sum!=0)
                return false;
        }
        return true;
    }
}
