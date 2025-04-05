/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 * 
 * 提示：
 * 所有 Node.val 互不相同。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */

// @lc code=start
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null || root.val == val1 || root.val == val2) {
            return root;
        }
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
// @lc code=end

