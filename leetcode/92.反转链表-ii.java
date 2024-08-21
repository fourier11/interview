/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 * 
 * 反转链表题型
 * 
 * 参考：
 * https://leetcode.cn/problems/reverse-linked-list-ii/solutions/1992226/you-xie-cuo-liao-yi-ge-shi-pin-jiang-tou-teqq/
 */

// @lc code=start
/**
 */
class Solution {
    private ListNode successor;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode p0 = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = 0; i < n - m + 1; i++) {
            ListNode next = cur.next;
            // 每次循环只修改一个next,比头插法更容易理解
            cur.next = pre;

            pre = cur;
            cur = next;
        }

        p0.next.next = cur;
        p0.next = pre;
        return dummyNode.next;
    }
}
// @lc code=end
