import java.util.LinkedList;

import sun.misc.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 * 
 * 岛屿题型
 * DFS
 */

// @lc code=start
class Solution {

    /**
     * DFS
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        // 遍历grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，数量+1
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * 岛屿变成海水
     */
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0  || i >= m || j >= n ) {
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 岛屿变成海水
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
// @lc code=end

