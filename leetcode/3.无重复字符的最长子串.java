/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        boolean[] used = new boolean[128];
        int max = 0;
        while (right < n) {
            // 在数组索引中，字符类型会自动转成ASCII
            if (used[s.charAt(right)] == false) {
                used[s.charAt(right)] = true;
                right++;
            } else {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}

