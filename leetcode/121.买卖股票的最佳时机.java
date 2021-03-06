/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 * 
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 
 * https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie-qing-an-shun-xu-yue-du/tuan-mie-gu-piao-wen-ti
 * 
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-121-best-time-to-buy-and-sell-stock/
 * 
 * 解法：
 * 只允许进行一次交易，相当于k=1
 */

// @lc code=start
class Solution {
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }

    /**
     * 模板方法
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    /**
     * 标准动态规划，空间复杂度比方法2高一点
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 1) {
            return 0;
        }
        int[] minPrices = new int[n];
        int[] maxProfit = new int[n];
        minPrices[0] = prices[0];
        maxProfit[0] = 0;
        for (int i = 1; i < n; i++) {
            minPrices[i] = Math.min(minPrices[i - 1], prices[i]);
            // 要么不选第i天，要么选择第i天
            maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minPrices[i - 1]);
        }
        return maxProfit[n - 1];
    }

}
// @lc code=end
