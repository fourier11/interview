/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 * 
 * 快慢指针题型
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 1. 先把0全部移除
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println("slow:" + slow + ",fast:" + fast);
        // 2. 末尾补充0
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}
// @lc code=end

