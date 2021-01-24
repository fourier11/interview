import java.util.Collections;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<Integer> res = new ArrayList<>();

    /**
     * 递归解法
     */
    public List<Integer> preorder2(Node root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (Node tmp : root.children) {
            preorder(tmp);
        }
        return res;
    }

    /**
     * 迭代解法
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            Collections.reverse(node.children);
            for (Node tmp : node.children) {
                stack.add(tmp);
            }
        }
        return res;
    }

}
// @lc code=end
