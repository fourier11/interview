/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 * 
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 注意条件：
 * 给定的 n 保证是有效的。
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        // 循环了n次
        while (n-- > 0) {
            fast = fast.next;
        }
        // 这一段非常关键，删除头结点的逻辑和其他节点是不同的
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow 是倒数第n+1个节点
        slow.next = slow.next.next;
        return head;
    }
}
// @lc code=end

