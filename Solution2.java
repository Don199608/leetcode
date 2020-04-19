package zzy.leecode;
/**
2. 两数相加		191118
    给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字0之外，这两个数都不会以0开头。
示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
*/

public class Solution2{

    // 1、迭代法：独立完成
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode prevhead = new ListNode(0); // 设定哨兵节点
        ListNode prev = prevhead;
        int carry = 0;                          // 定义加法进位项，0或1
        // 只要两个链表当前都非空，就进行相加处理
        while (l1!=null||l2!=null){
            int x = (l1!=null)?l1.val:0;
            int y = (l2!=null)?l2.val:0;
            int sum = carry + x + y;
            carry = sum/10;

            prev.next = new ListNode(sum%10); // 余数作为链表节点值
            prev = prev.next; // 迭代到下一节点进行处理

            // 非空则到下一个节点，空则没必要迭代下一节点
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 边界处理，最后一个的进位判断
        if (carry==1)
            prev.next = new ListNode(1);

        return  prevhead.next; // 返回哨兵节点后的链表
    }
}






























