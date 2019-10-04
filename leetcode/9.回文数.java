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
        int div = 1;
        int num = x;
        while (num / div >= 10) {
            div *= 10;
        }
        while (num != 0) {
            int left = num / div;
            int right = num % 10;
            if (left != right) {
                return false;
            }
            num = (num - left*div) / 10;
            div /= 100;
        }
        return true;
    }
}
// @lc code=end

