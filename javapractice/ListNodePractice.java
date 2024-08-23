/**
 * 链表相关的经典简单题型整理
 */
public class ListNodePractice {
    
    /**
     * 反转单链表,迭代解法
     */
    public static ListNode reverseList(ListNode head) {
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

    /**
     * 后驱节点
     */
    private static ListNode successor = null;

    /**
     * 反转前N个节点
     */
    public static ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转后的链表和后面的节点连到一起
        head.next = successor;
        return last;
    }

    /**
     * 反转m到n个节点
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 链表中a和b之间进行反转，注意区间是左闭右开
     */
    public static ListNode reverseFromAToB(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转单链表，递归解法
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 合并两个有序链表
     * 最好用迭代解法。
     * 递归解法，代码量更少，但是空间复杂度是O(m + n)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    /**
     * 合并两个有序链表,递归解法
     */
    public static ListNode mergListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergListNode(l1.next, l2);
            return l1;
        } else {
            l2.next = mergListNode(l1, l2.next);
            return l2;
        }
    }

    /**
     * 返回倒数第k个节点
     */
    public static ListNode findKthNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k < 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 这里一定要注意边界，i < k-1,快指针在正数第k个节点的前一个节点结束循环
        for (int i = 0 ; i < k - 1; i++) {
            fast = fast.next;
            // 这里的判空也很重要，可能出现链表非常短，小于k值
            if (fast == null) {
                return null;
            }
        }
        // 这里也要注意，结束的地方是快指针已经到了最后一个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 返回两个链表的第一个公共节点
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode res = mergListNode(node1, node4);
        printListNode(res);

        res = findKthNode(node4, 2);
        System.out.println("倒数第k个节点: " + res.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}