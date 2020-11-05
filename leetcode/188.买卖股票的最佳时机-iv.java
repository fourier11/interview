/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 * 
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 解法：
 * 股票问题最经典模板
 */

// @lc code=start
class Solution {

    /**
     * 模板方法，最后一个用例数据过多，会超出内存限制，导致无法通过最后一个用例
     * 推测是当prices数组偏大的时候，导致dp数据非常大，超出范围。
     */
    public int maxProfit2(int max_k, int[] prices) {
        int n = prices.length;
        if (max_k >= n / 2) {
            int dp_i_0 = 0;
            int dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }

        int[][][] dp = new int[n + 1][max_k + 1][2];
        for (int i = 1; i <= n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i == 1) {
                    dp[i - 1][k][0] = dp[i - 1][0][0] = 0;
                    dp[i - 1][k][1] = dp[i - 1][0][1] = Integer.MIN_VALUE;

                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][max_k][0];
    }

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // 当k非常大时转为无限次交易
        if (k >= n / 2) {
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, tmp - prices[i]);
            }
            return Math.max(dp0, dp1);
        }
        // 定义二维数组，交易了多少次、当前的买卖状态
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; ++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = k; j > 0; --j) {
                // 处理第k次买入
                dp[j - 1][1] = Math.max(dp[j - 1][1], dp[j - 1][0] - prices[i]);
                // 处理第k次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] + prices[i]);
            }
        }
        return dp[k][0];
    }
}
// @lc code=end
