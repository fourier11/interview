/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列 LongestCommonSubsequence
 * 
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 
 * 若这两个字符串没有公共子序列，则返回 0
 * 
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484486&amp;idx=1&amp;sn=0bdcb94c6390307ea32427757ec0072c&source=41#wechat_redirect
 * 
 * 动态规划题型  
 */

// @lc code=start
class Solution {

    /**
     * 自底向上动态规划
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]的含义是：对于s1[0..i-1]和s2[0..j-1]它们的 LCS 长度是dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // 索引为 0 的行和列表示空串, dp[0][..] = dp[..][0] = 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 现在i和j从1开始，所以要减1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // s1[i-1]和s2[j-1]必然在lcs中
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // s1[i-1]和s2[j-1]至少有一个不在lcs中
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
