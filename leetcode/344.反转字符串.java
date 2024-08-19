/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串,递归解法，时间效率比较低
 * 
 * 左右指针常用算法
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        // 迭代解法
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
// @lc code=end

