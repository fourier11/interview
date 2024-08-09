/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */

// @lc code=start
class Solution {
    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        // base case
        if (node == null) {
            return true;
        }
        int val = node.val;
        // 如果val不符合lower和upper限制，说明不是合法BST
        if ((lower != null && val <= lower) || (upper != null && val >= upper)) {
            return false;
        }
        // 左子树和右子树递归确认所有子树符合逻辑
        return helper(node.left, lower, val) && helper(node.right, val, upper);
    }


    public boolean isValidBST2(TreeNode root) {
        pre = null;
        return inOrder(root);
    }
    /**
     * 利用中序遍历，二叉搜索树的中序遍历肯定是有序
     */
    private boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inOrder(root.left)) {
            return false;
        }
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        return inOrder(root.right);
    }

}
// @lc code=end

