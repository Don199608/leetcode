package zzy.leecode;
/**
 * 160. 相交链表
 *  编写一个程序，找到两个单链表相交的起始节点。
 *
 *  注意：
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * */
public class Solution160 {
    // 1、拼接两个链表：
    //      A指针走过不相交A部分+相交部分+不相交B部分；
    //      B指针走过不相交B部分+相交部分+不相交A部分。
    //      两者路程等长，最后两个指针同时走到相交部分。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
