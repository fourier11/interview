/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%AD%90%E5%BA%8F%E5%88%97%E9%97%AE%E9%A2%98%E6%A8%A1%E6%9D%BF.md
 * 
 * 动态规划题型
 */

// @lc code=start
class Solution {

    /**
     * 自底向上解法
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        // dp定义：s[i..j]中，最长回文子串的长度为dp[i][j]
        int[][] dp = new int[len][len];
        // 反着遍历，保证正确状态转移
        for (int i = len - 1; i >=0; i--) {
            // base case
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 它俩一定在最长回文子序列中
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    // s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
// @lc code=end

