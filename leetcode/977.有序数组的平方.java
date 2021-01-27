/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        int pos = n - 1;
        while(i <= j) {
            if (nums[i]*nums[i] > nums[j]*nums[j]) {
                res[pos] = nums[i]*nums[i];
                i++;
            } else {
                res[pos] = nums[j]*nums[j];
                j--;
            }
            pos--;
        }
        return res;
    }
}
// @lc code=end

