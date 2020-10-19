/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 * 
 * 可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
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
                //题目要求可以忽略大小写，这里做了特殊处理，把大写字母转化为小写字母
                ch[cnt++] = (char)(ch[i] - 'A' + 'a');
            }
        }
        // 循环最后一次会多加一次
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

