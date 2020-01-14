/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串,递归解法，时间效率比较低
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    public void helper(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        char tmp = s[start];
        s[start++] = s[end];
        s[end--] = tmp;
        helper(s, start, end);
    }
}
// @lc code=end

