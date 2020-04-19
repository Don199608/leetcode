package zzy.leecode;

import java.util.concurrent.ExecutionException;

/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * */

// 1、基于数组实现的顺序栈
public class MinStack155 {
    private int[] ints; // 核心数组
    private int count; // 栈中元素个数
    private int n = 10; // 初始化栈大小
    /** initialize your data structure here. */
    public MinStack155() {
        this.ints = new int[n];
        this.count = 0;
    }

    public void push(int x) {
        // 动态扩容，由于只在此方法中使用，所以不单独列为方法
        if (count == n){
            n = n * 2;
            int[] temp = new int[n];
            System.arraycopy(ints,0,temp,0,count);
            ints = temp;
        }
        ints[count] = x;
        count++;
    }

    public void pop() {
        if (count>0){
            ints[count-1] = 0; // 由于不能将开拓的int类型定义为null，故暂定位0
            count--;
        }else {
            throw new RuntimeException("栈中元素为空，pop操作非法");
        }
    }

    public int top() {
        if (count>0)
            return ints[count-1];
        else
            throw new RuntimeException("栈中元素为空，top操作非法");
    }

    public int getMin() {
        if (count == 0)
            throw new RuntimeException("栈中元素为空，getMin操作非法");
        else if (count == 1)
            return ints[0];
        else {
            int temp = ints[0];
            for (int i=1;i<count;i++){
                if (ints[i]<temp)
                    temp = ints[i];
            }
            return temp;
        }
    }
}
