/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        int result = 0;
        for (int cnt : cnts) {
            result += (cnt / 2) * 2;
        }
        if (result < s.length()) {
            result++;
        }
        return result;
    }
}
// @lc code=end

