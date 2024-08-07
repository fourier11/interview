/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 * 
 * 前缀和
 */

// @lc code=start
class NumArray {
    private int[] dp;
    /**
     * 构造函数
     */
    public NumArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        dp = new int[n];
        // dp数组表示前n个数的加和，n从0开始
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return dp[j];
        }
        // 注意，这里是i-1，因为索引为i的数也要算进去
        return dp[j] - dp[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

