/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 * 
 * 岛屿题型
 * DFS
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    /**
     * 返回的是岛屿的面积
     */
    private int dfs(int i, int j, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        // 1是土地，0是海水
        if (grid[i][j] == 0) {
            return 0;
        }
        // 变成海水
        grid[i][j] = 0;
        return dfs(i + 1, j, grid) 
        + dfs(i - 1, j, grid) 
        + dfs(i, j + 1, grid) 
        + dfs(i, j - 1, grid) 
        + 1;
    }
}
// @lc code=end

