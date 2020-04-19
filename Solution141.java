package zzy.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
    * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
    * 输入：head = [3,2,0,-4], pos = 1
    * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * */
public class Solution141 {
    // 1、一次哈希查表
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodeSet = new HashSet<>();
//        while (head!=null){
//            if (nodeSet.contains(head))
//                return true;
//            else{
//                nodeSet.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    // 2、快慢指针
    public boolean hasCycle1(ListNode head) {
        // 边界条件判断
        if (head==null||head.next==null)
            return false;
        // 声明快慢指针对象
        ListNode slow = head;
        ListNode fast = head.next;
        // 若链表有环，快慢指针最终会遇见，时间复杂度O(n)
        while(slow!=fast){
            if (fast==null||fast.next==null) // 一旦快指针到达链表尾部，说明链表没有环
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
