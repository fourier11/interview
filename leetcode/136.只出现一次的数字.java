/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字,注意，题目中明确说明了其他重复的数字是一定出现了2次，所以才可以用异或的方式求解
 * 
 * 位操作思路：
 * 0 和 二进制数做异或，仍然是这个二进制
 * 相同的二进制做异或，结果为0
 * XOR满足交换律和结合律
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end

