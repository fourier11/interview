/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 * 解法：需要用到动态规划
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for(int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                match[0][i] = match[0][i - 2];
            }
        }

        for(int si = 1; si <= s.length(); si++) {
            for(int pi = 1; pi <= p.length(); pi++) {
                if(p.charAt(pi - 1) == '.' || p.charAt(pi - 1) == s.charAt(si - 1)) {
                    match[si][pi] = match[si - 1][pi - 1];
                } else if (p.charAt(pi - 1) == '*') {
                    if(p.charAt(pi - 2) == s.charAt(si - 1) || p.charAt(pi - 2) == '.') {
                        match[si][pi] = match[si][pi - 2] || match[si - 1][pi];
                    } else {
                        match[si][pi] = match[si][pi - 2];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
// @lc code=end

