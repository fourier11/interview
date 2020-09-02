import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {

    /**
     * DFS解法
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                // 注意，这里第三个参数是j，表明针对哪个数字进行深度优先遍历
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNumWithBFS(int[][] M) {
        int[] visited = new int[M.length];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int tmp = queue.poll();
                    visited[tmp] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[tmp][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
