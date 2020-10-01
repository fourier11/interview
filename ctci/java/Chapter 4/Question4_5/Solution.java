class Solution {
    long pre;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        pre = Long.MIN_VALUE;
        flag = true;
        help(root);
        return flag;
    }

    void help(TreeNode root) {
        if (root == null || !flag)
            return;
        help(root.left);
        if (root.val > pre)
            pre = root.val;
        else
            flag = false;
        help(root.right);
    }
}
