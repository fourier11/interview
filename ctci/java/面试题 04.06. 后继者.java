/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 面试题 04.06. 后继者
 * 
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。如果指定节点没有对应的“下一个”节点，则返回null。
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        if (root.val <= p.val) {
            TreeNode right = inorderSuccessor(root.right, p);
            return right;
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root; 
        }
    }
}