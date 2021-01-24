import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> visited = new HashMap<>();

    /**
     * DFS
     */
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList());
        visited.put(node, cloneNode);
        
        for (Node tmp: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(tmp));
        }
        return cloneNode;
    }

    /**
     * BFS
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // key 是原来的node，value是clone出来的node
        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                // 更新当前clone结点的邻居
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
// @lc code=end

