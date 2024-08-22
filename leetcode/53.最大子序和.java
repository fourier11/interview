import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-53-maximum-subarray/
 * 
 * 动态规划
 */

// @lc code=start
class Solution {

    /**
     * 动态规划 时间复杂度O(n),空间复杂度O(n)
     */
    public int maxSubArray2(int[] nums) {
        // dp[i] maxSubArray(0..i)，表示以第i个元素结尾的最大子序列和，必须要有第i个元素结尾。
        int[] dp = new int[nums.length];
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp[i] = dp[i-1] > 0 ? nums[i] + dp[i-1] : nums[i];
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    /**
     * 空间压缩后的DP实现
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp_0 = nums[0];
        int dp_1 = 0;
        int res = dp_0;
        for (int i = 1; i < n; i++) {
            // dp[i] = max(nums[i], nums[i] + dp[i-1])
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            // 顺便计算最大结果
            res = Math.max(res, dp_1);
        }
        return res;
    }
}
// @lc code=end
