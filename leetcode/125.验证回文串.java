/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < ch.length; i++) {
            if (('0' <= ch[i] && ch[i] <= '9') || ('a' <= ch[i] && ch[i] <= 'z')) {
                ch[cnt++] = ch[i];
            } else if ('A' <= ch[i] && ch[i] <= 'Z') {
                ch[cnt++] = (char)(ch[i] - 'A' + 'a');
            }
        }
        cnt--;
        int j = 0;
        while (j < cnt) {
            if (ch[j++] != ch[cnt--]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

