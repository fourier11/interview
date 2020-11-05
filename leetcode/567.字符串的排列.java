import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 
 * 输入的字符串只包含小写字母
 * 
 * 滑动窗口题型
 */

// @lc code=start
class Solution {

    public boolean checkInclusion(String t, String s) {
        int[] need = new int[255];
        int[] window = new int[255];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need[c] != 0) {
                window[c]++;
                if (window[c] <= need[c]) {
                    valid++;
                }
            }

            while (right - left >= t.length()) {
                if (valid == t.length()) {
                    return true;
                }
                char d = s.charAt(left);
                left++;
                if (need[d] != 0) {
                    if (window[d] <= need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }
        return false;
    }
}
// @lc code=end