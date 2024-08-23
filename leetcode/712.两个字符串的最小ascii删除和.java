/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 * 
 * 动态规划题型
 */

// @lc code=start
class Solution {
    /**
     * 自底向上写法
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // s2 为空字符串场景
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        // s1 为空字符串
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i-1) + dp[i-1][j],
                        s2.charAt(j-1) + dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
