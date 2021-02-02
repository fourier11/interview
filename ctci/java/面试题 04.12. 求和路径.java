/**
 * 求和路径
 * 
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * https://leetcode-cn.com/problems/paths-with-sum-lcci/
 * 
 * 回溯法
 */
class Solution {
    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            res++;
        }
        helper(root.left, sum);
        helper(root.right, sum);
        // 这一步很关键，回溯之后sum要恢复原状
        sum += root.val;
    }
}