/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 动态规划题型
 */

// @lc code=start
class Solution {
    private int[][] dp;

    /**
     * 记忆化递归解法，自上而下DP
     */
    public int minPathSum(int[][] grid) {
        // 这里dp是从(0,0)开始
        dp = new int[grid.length][grid[0].length];
        return dfs(grid.length - 1, grid[0].length - 1, grid);
    }

    private int dfs(int x, int y, int[][] grid) {
        if (x < 0 || y < 0) {
            // 索引出界，给一个很大的值，避免取min的时候被渠道
            return Integer.MAX_VALUE;
        }
        // base case
        if (x == 0 && y == 0) {
            return grid[0][0];
        }
        // 记忆化
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        // 状态转移
        dp[x][y] = Math.min(dfs(x - 1, y, grid), dfs(x, y - 1, grid)) + grid[x][y];
        return dp[x][y];
    }

    /**
     * 自下而上DP
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        // 从(0,0)开始
        dp[0][0] = grid[0][0];
        // base case
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
// @lc code=end
