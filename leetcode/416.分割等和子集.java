/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 * 
 * https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie-qing-an-shun-xu-yue-du/bei-bao-zi-ji
 * 
 * 0-1背包变种问题
 * 
 * 动态规划题型
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            // 和为奇数时，不可能划分为2个和相等的集合
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        // 定义：dp[i][j] = x, 前i个物品（i从1开始），当容量为j时，若x为true，说明背包恰好装满。若x为false说明不能恰好把背包装满。
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或者不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
// @lc code=end
