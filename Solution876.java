package zzy.leecode;
/**
 * 876. 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 * */
public class Solution876 {
    // 1、二次遍历
    public ListNode middleNode(ListNode head) {
        // 边界条件判断
        if (head==null||head.next==null)
            return head;

        int len = 0;
        ListNode curr = head;
        while (curr!=null){
            curr = curr.next;
            len ++;
        }
        curr = head;
        int index = len/2;
        for (int i=0;i<index;i++)
            curr = curr.next;
        return curr;
    }

    // 2、快慢指针法
    // 快指针到达末尾，慢指针到达中间点
    // 有误！！！但是思想可以借鉴
    public ListNode middleNode1(ListNode head){
        ListNode slow = head, fast = head.next;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
