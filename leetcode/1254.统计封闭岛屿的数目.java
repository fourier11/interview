/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 * 
 * 注意：边缘不算岛屿，而是陆地
 * 
 * 岛屿题型
 * DFS
 */

// @lc code=start
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 0; j < n; j++) {
            // 把靠上边的岛屿淹没
            dfs(grid, 0, j);
            // 把靠下边岛屿淹没
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 把靠左边的岛屿淹没
            dfs(grid, i, 0);
            // 把靠右边岛屿淹没
            dfs(grid, i, n - 1);
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        // 0是土地，1是海水，这里是把土地变成海水
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i , j + 1);
    }
}
// @lc code=end
