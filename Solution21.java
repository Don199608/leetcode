package zzy.leecode;

/**
 * 21. 合并两个有序链表
    * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
 * */

public class Solution21 {
    // 1、迭代法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1); //定义一个哨兵节点
        ListNode prev = prehead;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 当其中一个单链表为空时，直接指向另一个非空链表的剩余部分
        prev.next = (l1!=null)?l1:l2;
        return prehead.next; //去掉哨兵节点
    }

    // 2、递归法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        else if (l2==null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
