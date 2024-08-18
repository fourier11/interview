/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 * 
 * 类似26题，删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                // 注意，这里先给nums[slow]赋值，然后slow++
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
// @lc code=end

