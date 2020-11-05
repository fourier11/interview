/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 * 
 * 滑动窗口题型
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%8A%80%E5%B7%A7.md
 */
class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window[c]++;
            // 判断左侧是否需要收缩，大于1表示已经有重复字符了
            while (window[c] > 1) {
                char d = s.charAt(left);
                left++;
                window[d]--;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
