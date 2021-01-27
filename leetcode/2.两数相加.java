/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int nums1 = l1 == null ? 0 : l1.val;
            int nums2 = l2 == null ? 0 : l2.val;
            int num = nums1 + nums2 + carry;
            carry = num / 10;
            cur.next = new ListNode(num % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return res.next;
    }
}
// @lc code=end

