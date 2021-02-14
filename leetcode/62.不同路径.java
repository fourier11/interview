/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 
 * 求多少个解法，通常可以用到动态规划，而且还能用到递归解法
 */

// @lc code=start
class Solution {

    /**
     * 记忆化递归解法
     */
    public int uniquePaths2(int m, int n) {
        int[][] mem = new int[m + 1][n + 1];
        return helper(m, n, mem);
    }

    private int helper(int m, int n, int[][] mem) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        if (mem[m][n] > 0) {
            return mem[m][n];
        }
        int left = helper(m - 1, n, mem);
        int top = helper(m, n - 1, mem);
        mem[m][n] = left + top;
        return mem[m][n];
    }

    /**
     * 动态规划法,自底向上，这个方法耗时更低 但是边界问题更复杂，需要考虑清楚
     */
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
