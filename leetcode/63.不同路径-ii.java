import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 * 
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * https://www.youtube.com/watch?v=8v-dX6ato_Y&feature=emb_logo
 */

// @lc code=start
class Solution {
    /**
     * 记忆化递归解法
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 注意这里mem的起始点为（1,1）
        int[][] mem = new int[m + 1][n + 1];
        return helper(m, n, obstacleGrid, mem);
    }

    private int helper(int x, int y, int[][] obstacleGrid, int[][] mem) {
        if (x <= 0 || y <= 0) {
            return 0;
        }
        if (x == 1 && y == 1) {
            return 1 - obstacleGrid[0][0];
        }
        if (mem[x][y] != 0) {
            return mem[x][y];
        }
        if (obstacleGrid[x - 1][y - 1] == 1) {
            mem[x][y] = 0;
        } else {
            mem[x][y] = helper(x - 1, y, obstacleGrid, mem) + helper(x, y - 1, obstacleGrid, mem);
        }
        return mem[x][y];
    }

    /**
     * 自底而上动态规划解法
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        if (obstacleGrid[0][0] == 1) {
            dp[1][1] = 0;
        } else {
            dp[1][1] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
