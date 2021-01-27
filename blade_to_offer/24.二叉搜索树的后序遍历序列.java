
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        //左子树的任意节点小于根节点
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        // 右子树的任意节点大于根节点
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}