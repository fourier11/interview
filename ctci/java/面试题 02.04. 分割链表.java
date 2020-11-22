/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x
 * 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 */
class Solution {
    public ListNode partition(ListNode node, int x) {
        if (node == null) {
            return node;
        }
        ListNode head = node;
        ListNode tail = node;

        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        // 这里需要注意一下，尾节点最后要指向空，不然会存在环
        tail.next = null;
        return head;
    }
}