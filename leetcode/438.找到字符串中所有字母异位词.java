import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 * 
 * 滑动窗口题型
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%8A%80%E5%B7%A7.md
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        int[] need = new int[255];
        int[] window = new int[255];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            int c = s.charAt(right);
            right++;
            if (need[c] != 0) {
                window[c]++;
                if (window[c] <= need[c]) {
                    valid++;
                }
            }

            while (right - left >= t.length()) {
                if (valid == t.length()) {
                    res.add(left);
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
        return res;
    }
}
// @lc code=end
