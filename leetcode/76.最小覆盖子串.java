/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 * 
 * 滑动窗口问题
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&chksm=9bd7f8ddaca071cbb7570b2433290e5e2628d20473022a5517271de6d6e50783961bebc3dd3b&scene=21#wechat_redirect
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[255];
        int[] window = new int[255];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need[c] != 0) {
                window[c]++;
                if (window[c] <= need[c]) {
                    valid++;
                }
            }
            // 如果符合要求，移动 left 缩小窗口
            while (valid == t.length()) {
                // 如果这个窗口的子串更短，则更新 res
                if (right - left < len) {
                    start = left;
                    len = right - left;
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
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
// @lc code=end
