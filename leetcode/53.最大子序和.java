import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-53-maximum-subarray/
 */

// @lc code=start
class Solution {

    /**
     * 动态规划 时间复杂度O(n),空间复杂度O(n)
     */
    public int maxSubArray2(int[] nums) {
        // dp[i] maxSubArray(0..i)，表示以第i个元素结尾的最大子序列和，必须要有第i个元素结尾。
        // dp[i] = dp[i-1] > 0 ? nums[i] + dp[i-1] : nums[i];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}
// @lc code=end
