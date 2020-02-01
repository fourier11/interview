/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int preLen = 0;
        int curLen = 1;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            // TODO:为什么是大于等于，不是等于
            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

