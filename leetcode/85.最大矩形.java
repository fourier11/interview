/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 * 
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-85-maximal-rectangle/
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == 0 ? 0 : dp[i][j - 1]) + 1;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = Integer.MAX_VALUE;
                for (int k = i; k < m; k++) {
                    len = Math.min(len, dp[k][j]);
                    if (len == 0) {
                        break;
                    }
                    ans = Math.max(ans, len * (k - i + 1));
                }
            }
        }
        return ans;
    }
}
// @lc code=end
