/*
 * @lc app=leetcode.cn id=1312 lang=java
 *
 * [1312] 让字符串成为回文串的最少插入次数
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }

    /**
     * 最长回文子序列
     */
    private int longestPalindromeSubseq(String s) {
        int m = s.length();
        // dp定义：s[i..j]中，最长回文子串的长度为dp[i][j]
        int[][] dp = new int[m][m];
        for (int i = m - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < m; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][m - 1];
    }
}
// @lc code=end
