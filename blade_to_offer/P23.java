import java.util.*;

import javax.swing.tree.TreeNode;

/**
 * public class TreeNode { int val = 0; TreeNode left = null; TreeNode right =
 * null;
 * 
 * public TreeNode(int val) { this.val = val;
 * 
 * }
 * 
 * }
 * 自上而下打印二叉树（二叉树的按层遍历）
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            while(cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null) {
                    continue;
                }
                result.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return result;
    }
}