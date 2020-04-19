package zzy.leecode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * */

public class Solution206 {
    // 1、迭代法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next; // 保留下一节点
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // 反转后，curr指向null，变为哨兵节点，所以返回prev
    }

    // 2、递归法
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head; // 边界判断，空或只有一个节点返回
        ListNode p = reverseList1(head.next); // 递归部分
        head.next.next = head; // 链表反转
        head.next = null;
        return p;
    }
}
