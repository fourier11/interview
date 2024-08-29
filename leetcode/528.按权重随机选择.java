/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 * 
 * 前缀和+二分查找
 */

// @lc code=start

import java.util.Random;

class Solution {

    private int[] preSum;

    private Random rand = new Random();

    public Solution(int[] w) {
        int n = w.length;
        // 前缀数组和，需要偏移一位，留给preSum[0]
        preSum = new int[n + 1];
        preSum[0] = 0;
        // preSum[i] = sum(w[0..i-1])
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + w[i-1];
        }
    }
    
    public int pickIndex() {
        int n = preSum.length;
        int target = rand.nextInt(preSum[n-1]) + 1;
        return leftBound(preSum, target) - 1;
    }

    private int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

