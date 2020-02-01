/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 给定一个整数，将其转化为7进制，并以字符串形式输出。
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        String ret = sb.reverse().toString();
        return isNegative ? "-" + ret : ret;
    }
}
// @lc code=end

