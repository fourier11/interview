/**
 * 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > res) {
                res = count;
            }
            if (count < 0) {
                count = 0;
            }
        }
        return res;
    }
}