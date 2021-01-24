import java.util.List;

/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
    private List<Integer> leafs1 = new ArrayList<>();
    private List<Integer> leafs2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeafs(root1, leafs1);
        getLeafs(root2, leafs2);
        return leafs1.equals(leafs2);
    }

    /**
     * DFS
     */
    private void getLeafs(TreeNode root, List<Integer> leafs) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        }
        getLeafs(root.left, leafs);
        getLeafs(root.right, leafs);
    }
}
// @lc code=end

