/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * 
 * 解法：
 * BFS
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<ListNode> list = new ArrayList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 这里比较巧妙，设置一个空的头结点
            ListNode head = new ListNode(0);
            ListNode cur = head;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(head.next);
        }
        ListNode[] res = new ListNode[list.size()];
        return list.toArray(res);
    }
}