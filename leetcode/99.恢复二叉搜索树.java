/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 */

// @lc code=start
class Solution {
    TreeNode x , y, pred = null;
    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    private void findTwoSwapped(TreeNode root) {
        if (root == null) {
            return;
        }
        findTwoSwapped(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
                x = pred;
            } else {
                return;
            }
        }
        pred = root;
        findTwoSwapped(root.right);
    }

    private void swap (TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
// @lc code=end

