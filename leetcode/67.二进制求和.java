/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 统计同一位上1的个数
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            sb.append(carry % 2);
            carry /= 2; 
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

