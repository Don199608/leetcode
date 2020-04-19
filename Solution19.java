package zzy.leecode;
/**
 19. 删除链表的倒数第N个节点
     给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 示例：
     给定一个链表: 1->2->3->4->5, 和 n = 2.
     当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：
     给定的 n 保证是有效的。
 进阶：
     你能尝试使用一趟扫描实现吗？
 * */

public class Solution19{
    // 1、两次遍历法
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int len = 0;
        ListNode prev = new ListNode(-1); // 哨兵节点
        prev.next = head;
        ListNode first = head;
        while (first!=null){
            first = first.next;
            len ++;
        }
        first = prev;
        len -= n;
        while (len>0){
            len--;
            first = first.next;
        }
        first.next = first.next.next;
        return prev.next; // 去除哨兵节点
    }

    // 2、一次遍历法：定义左、右两个指针，右指针后移n个节点，若右指针为null，则左指针跳过下一个节点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode left = prev;
        ListNode right = prev;
        for (int i=0;i<n;i++){
            right = right.next;
        }
        while (right.next!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return prev.next;
    }
}
