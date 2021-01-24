/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int val;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        val = root.val;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return dfs(root.left) && dfs(root.right);
    }
}
// @lc code=end

