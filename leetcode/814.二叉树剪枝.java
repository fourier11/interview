/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
 * 
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
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
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (containNoOne(root)) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }

    private boolean containNoOne(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val == 1) {
            return false;
        }
        return containNoOne(root.left) && containNoOne(root.right);
    }
}
// @lc code=end

