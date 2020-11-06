/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E6%8A%A2%E6%88%BF%E5%AD%90.md
 */

// @lc code=start
class Solution {
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    /**
     * 由于dp[i]只与前两个状态有关，这种解法更节省空间
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int dp_i = nums[0];
        // 相当于dp[i-1]
        int dp_i_1 = nums[0];
        // 相当于dp[i-2]
        int dp_i_2 = 0;
        for (int i = 2; i <= len; i++) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i - 1]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
// @lc code=end
