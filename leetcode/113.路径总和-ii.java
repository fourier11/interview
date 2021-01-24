import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 * 
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(root, sum, res, tmp);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(tmp));
        }
        dfs(root.left, sum - root.val, res, tmp);
        dfs(root.right, sum - root.val, res, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
// @lc code=end

