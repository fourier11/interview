import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 思路：
 * 深度优先遍历
 * 
 * 注意：一定要到叶子节点才算
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == tar) {
            res.add(new ArrayList(path));
            path.remove(path.size() - 1);
            return;
        }
        dfs(root.left, tar - root.val);
        dfs(root.right, tar - root.val);
        path.remove(path.size() - 1);
    }
}