
public class ListNodePractice {
    /**
     * 反转单链表，经典题型
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = pre;

            pre = curr;
            curr = nextTmp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}