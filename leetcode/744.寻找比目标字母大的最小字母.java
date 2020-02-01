/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }
}
// @lc code=end

