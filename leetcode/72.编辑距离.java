/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E7%BC%96%E8%BE%91%E8%B7%9D%E7%A6%BB.md
 * 
 * 动态规划
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    private int[][] memo;
    /**
     * 自底向上动态规划
     */
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 定义：word1[0..i] 和 word[0..j] 的最小距离是dp[i+1][j+1]
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        // 自底向上解法
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 自顶而下动态规划，并且添加备忘录
     */
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s1, m - 1, s2, n-1);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i-1, s2, j-1);
        } else {
            memo[i][j] = min(dp(s1, i, s2, j -1) + 1,
            dp(s1, i-1, s2, j) + 1,
            dp(s1, i-1, s2, j-1) + 1);
        }
        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(c, b));
    }
}
// @lc code=end
