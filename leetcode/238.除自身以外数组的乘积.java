/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R = nums[i] * R;
        }
        return answer;
    }
}
// @lc code=end
