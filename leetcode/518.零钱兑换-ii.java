/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 * https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie-qing-an-shun-xu-yue-du/bei-bao-ling-qian
 */

// @lc code=start
class Solution {

    /**
     * 完全背包模板方法
     */
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        // dp[i][j]表示前i个硬币凑出j值有多少种凑法
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * dp 数组的转移只和 dp[i][..] 和 dp[i-1][..] 有关，所以可以压缩状态
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
// @lc code=end
