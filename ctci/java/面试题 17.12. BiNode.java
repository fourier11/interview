/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * 
 * 返回转换后的单向链表的头节点。
 * 
 * 注意：本题相对原题稍作改动
 * 
 */
class Solution {
    TreeNode head = new TreeNode(-1);
    TreeNode pre;
    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre == null) {
            // 以下是对第一个节点的处理
            pre = root;
            head.right = root;
        } else {
            pre.right = root;
            pre = root;
        }
        root.left = null;
        helper(root.right);
    }
}