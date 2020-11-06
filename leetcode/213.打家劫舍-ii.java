/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 * 
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 1), robRange(nums, 1, n));
    }

    private int robRange(int[] nums, int start, int end) {
        int dp_i = nums[start];
        int dp_i_1 = nums[start];
        int dp_i_2 = 0;
        for (int i = start + 2; i <= end; i++) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i - 1]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
// @lc code=end
