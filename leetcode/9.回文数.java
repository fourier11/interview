/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 判断是否为回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        // y是x翻转后的数字
        int y = 0;
        while (temp > 0) {
            int last_num = temp % 10;
            temp = temp / 10;
            // 高位生成数字
            y = y * 10 + last_num;
        }
        return y == x;
    }
}
// @lc code=end
