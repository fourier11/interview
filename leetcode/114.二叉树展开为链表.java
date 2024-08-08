/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * 
 * 思路：
 * 如果用前序遍历，要构造一个新的节点返回，题目的返回类型是void，说明要在原来的树上进行操作。
 * 所以要用到分解问题的思想
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1.先将左子树和右子树拉平
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2.将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3.将原先的右子树接到当前右子树的末端
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
// @lc code=end

