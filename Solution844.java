package zzy.leecode;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * */
public class Solution844 {
    private Stack<Character> s1 = new Stack<>(), s2 = new Stack<>();
    private char a,b;

    public boolean backspaceCompare(String S, String T) {
        for (char c : S.toCharArray()){
            // 不等于#，则压入栈中
            if (c!='#')
                s1.push(c);
            // 等于#，非空则弹出模仿退格
            else
                if (!s1.empty())
                    s1.pop();
        }
        for (char c : T.toCharArray()){
            if (c!='#')
                s2.push(c);
            else
            if (!s2.empty())
                s2.pop();
        }

        // 判断两个栈内容是否相等
        if (s1.size()==s2.size()){
            while (!s1.empty()){
                a = s1.pop();
                b = s2.pop();
                // 一旦不同false
                if (a!=b)
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}
