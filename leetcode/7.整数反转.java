/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
class Solution {
    
    public int reverse(int x) {
        long tmp = 0;
        while (x != 0) {
            int pop = x % 10;
            tmp = tmp * 10 + pop;
            if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int)tmp;
    }
}

