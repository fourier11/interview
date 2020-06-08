/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int i, j;
        int maxPos = -1;
        for (i = 0; i <= nums.length - k; ++i) {
            j = i + k - 1;
            if (maxPos != -1 && nums[j] >= nums[maxPos]) {
                maxPos = j;
                res[i] = nums[maxPos];
            } else if (i <= maxPos) {
                res[i] = nums[maxPos];
            } else {
                int maxWindow = Integer.MIN_VALUE;
                int maxPosWindow = 0;
                for (int z = i; z <= j; ++z) {
                    if (nums[z] > maxWindow) {
                        maxPosWindow = z;
                        maxWindow = nums[z];
                    }
                }
                maxPos = maxPosWindow;
                res[i] = maxWindow;
            }
        }
        return res;
    }
}
// @lc code=end

