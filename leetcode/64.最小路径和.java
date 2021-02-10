/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */

// @lc code=start
class Solution {
    int[][] dp;

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        return dfs(grid.length - 1, grid[0].length - 1, grid);
    }

    private int dfs(int x, int y, int[][] grid) {
        // 边界
        if (x == 0 && y == 0) {
            return grid[0][0];
        }
        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }
        // 记忆化
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        // 状态转移
        dp[x][y] = Math.min(dfs(x - 1, y, grid), dfs(x, y - 1, grid)) + grid[x][y];
        return dp[x][y];
    }
}
// @lc code=end

