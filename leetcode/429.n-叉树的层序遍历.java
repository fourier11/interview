import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import SkipList.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levels = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                levels.add(node.val);
                for (Node tmp : node.children) {
                    queue.add(tmp);
                }
            }
            res.add(levels);
        }
        return res;
    }
}
// @lc code=end

