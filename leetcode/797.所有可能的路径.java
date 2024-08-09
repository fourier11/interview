/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 * 
 * 无环图，不需要visited数组
 */

// @lc code=start

import java.util.LinkedList;

class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0, new LinkedList<>());
        return res;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        // 将节点s加入路径
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        // 从路径移除节点s
        path.removeLast();
    }
}
// @lc code=end

