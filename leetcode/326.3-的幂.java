/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 * 
 * 解法：
 * 这种方法是最容易想到的暴力解法
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
// @lc code=end

