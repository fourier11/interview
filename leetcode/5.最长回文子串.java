import javax.sound.midi.SysexMessage;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 * 
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484471&idx=1&sn=7c26d04a1f035770920d31377a1ebd42&chksm=9bd7fa3faca07329189e9e8b51e1a665166946b66b8e8978299ba96d5f2c0d3eafa7db08b681&scene=21#wechat_redirect
 */

// @lc code=start
class Solution {
    // 动态规划法，时间复杂仍然为O(N^2),没有完全理解
    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i)== s.charAt(j)) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }
    // 中心扩散法
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String tmp1 = helper(s, i, i);
            String tmp2 = helper(s, i, i + 1);
            res = res.length() > tmp1.length() ? res : tmp1;
            res = res.length() > tmp2.length() ? res : tmp2;
        }
        return res;
    }


    private String helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            // 注意，这里的日志打印只能用于调试，如果submit，会导致超时问题
            // System.out.println("l=" + l);
            // System.out.println("r=" + r);
        }
        // 注意，这里和 C 不同，substring的第二个参数是右侧开区间
        return s.substring(l + 1, r);
    }
}
// @lc code=end

