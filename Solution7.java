package zzy.leecode;

/*
7. 整数反转
给出一个32位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321
示例 2:
输入: -123
输出: -321
示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下32位的有符号整数，则其数值范围为[−2^31,2^31−1]。请根据这个假设，如果反转后整数溢出那么就返回0。
* */
//public class Solution7 {
//    public int reverse(int x){
//        int INT_MAX = 2147483647;
//        int INT_MIN = -2147483648;
//        if (x<INT_MIN||x>INT_MAX)
//            return 0;
//        String s1 = String.valueOf(Math.abs(x));    //int转String
//        char[] c1 = s1.toCharArray();               //String转char[]
//        int l = c1.length;
//        char[] c2 = new char[l];
//        for (int i=0;i<l;i++){
//            c2[i]=c1[l-1-i];
//        }
//        String s3=new String(c2);                   //char[]转String
//        int r = Integer.valueOf(s3).intValue();     //String转int
//        if (x<0)
//            r = -r;
//        return r;
//    }
//}

//方法二：官方解答
public class Solution7 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;       //获取x最后一位
            x /= 10;                //右移一位
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}