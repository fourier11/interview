/*
 * @lc app=leetcode.cn id=1905 lang=java
 *
 * [1905] 统计子岛屿
 * 
 * 岛屿题型
 * 
 * 思路：
 * 循环遍历两个二维数组，如果不一致，肯定不可能是子岛屿，直接淹掉
 */

// @lc code=start
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] != grid2[i][j]) {
                    // 这个岛屿肯定不是子岛屿，淹掉
                    dfs(grid2, i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
            return;
        }
        if (grid[i][j] == 0) {
            // 如果是海水，直接跳过
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }
}
// @lc code=end

