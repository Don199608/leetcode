package zzy.leecode;

import java.util.Stack;
import java.util.concurrent.ExecutionException;

/**
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

// 1、使用两个栈互相pop、push实现队列，入队-O(n)、出队-O(1)
//public class MyQueue232 {
//    // 需要由两个LIFO的栈实现队列FIFO
//    private Stack<Integer> s1,s2;
//    private int front;
//
//    /** Initialize your data structure here. */
//    public MyQueue232() {
//        this.s1 = new Stack<>();
//        this.s2 = new Stack<>();
//    }
//
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        if (s1.empty())
//            front = x;
//        while (!s1.isEmpty())
//            s2.push(s1.pop());
//        s2.push(x);
//        while (!s2.isEmpty())
//            s1.push(s2.pop());
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    public int pop() {
//        if (s1.empty())
//            throw new RuntimeException("队列为空，无法pop！！！");
//        else {
//            int top = s1.pop();
//            if (!s1.empty())
//                front = s1.peek();
//            return top;
//        }
//    }
//
//    /** Get the front element. */
//    public int peek() {
//        if (s1.empty())
//            throw new RuntimeException("队列为空，无法peek！！！");
//        else {
//            return s1.peek();
//        }
//    }
//
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        return s1.empty();
//    }
//}

// 2、优化方法：使用两个栈，入队-O(n)、出队-摊还复杂度O(1)
public class MyQueue232 {

    private Stack<Integer> s1,s2;
    private int front;

    /** Initialize your data structure here. */
    public MyQueue232() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 默认第一个入队列的数为栈头
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // s2空的时候，将s1所以值全部压入s2中
        if (s2.empty()){
            // 当s1非空
            while (!s1.empty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
