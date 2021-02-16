/*
 * @lc app=leetcode.cn id=1277 lang=java
 *
 * [1277] 统计全为 1 的正方形子矩阵
 * 
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * 
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1277-count-square-submatrices-with-all-ones/
 */

// @lc code=start
class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j]表示以 (i, j) 为右下角的正方形的最大边长，dp[i][j] = x 也表示以 (i, j) 为右下角的正方形的数目为 x（即边长为
        // 1, 2, ..., x 的正方形各一个）
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
// @lc code=end

