class Solution {
    TreeNode head = new TreeNode(-1);
    TreeNode pre;
    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre == null) {
            // 以下是对第一个节点的处理
            pre = root;
            head.right = root;
        } else {
            pre.right = root;
            pre = root;
        }
        root.left = null;
        helper(root.right);
    }
}