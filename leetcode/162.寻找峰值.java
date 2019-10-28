/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

