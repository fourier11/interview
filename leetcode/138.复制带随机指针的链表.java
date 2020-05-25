/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 间隔插入node节点
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立random链接
        cur = head;
        while(cur != null) {
            Node clone = cur.next;
            if(cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // 断开连接,相当于cur删除clone节点
        cur = head;
        Node pClone = cur.next;
        while(cur.next != null) {
            Node tmp = cur.next;
            cur.next = tmp.next;
            cur = tmp;
        }
        return pClone;
    }
}
// @lc code=end

