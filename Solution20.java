package zzy.leecode;

import java.util.HashMap;
import java.util.Stack;

/**
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:
输入: "()"
输出: true
示例 2:
输入: "()[]{}"
输出: true
示例 3:
输入: "(]"
输出: false
示例 4:
输入: "([)]"
输出: false
示例 5:
输入: "{[]}"
输出: true
 */

class Solution20 {

    // 初始化一个map对象用于存放括号对
    private HashMap<Character,Character> map = new HashMap<>();

    public Solution20(){

        // 在构造器中定义map，在map的键值对中放入括号对
        this.map = new HashMap<Character,Character>();
        this.map.put(')','(');
        this.map.put(']','[');
        this.map.put('}','{');
    }

    public boolean isValid(String s) {
        // 初始化栈对象
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            // 提取字符串中第i个字符
            char curr = s.charAt(i);
            // 包含key，即括号对的右侧，弹出栈中top元素，用于键值对的对比
            if(this.map.containsKey(curr)){
                char top = stack.empty() ? '#':stack.pop();
                if(top != this.map.get(curr))
                    return false;
            }
            // 将括号的左侧全部压入栈中
            else{
                stack.push(curr);
            }
        }
        return stack.empty();
    }
}

