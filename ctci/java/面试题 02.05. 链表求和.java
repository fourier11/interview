/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * 
 * 
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        // 头结点是个无意义的结点，方便后续操作
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        // 只有l1和l2都走完，才会结束
        while (l1 != null || l2 != null) {
            // 如果其中一个结点为空，需要补0
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int num = num1 + num2 + carry;
            carry = num / 10;
            cur.next = new ListNode(num % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return ans.next;
    }
}