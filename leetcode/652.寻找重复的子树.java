import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
 * 
 * https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie-qing-an-shun-xu-yue-du/er-cha-shu-xi-lie-3
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
    private HashMap<String, Integer> mem = new HashMap<>();
    private List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    private String helper(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = helper(root.left);
        String right = helper(root.right);
        String subTree = left + "," + right + "," + root.val;
        int freq = mem.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }
        mem.put(subTree, freq + 1);
        return subTree;
    }
}
// @lc code=end

