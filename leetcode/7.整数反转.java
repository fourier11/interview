/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 输入：x = 123 输出：321
 */
class Solution {
    
    public int reverse(int x) {
        // 反转后可能超出整数范围，这里tmp必须用long型
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

