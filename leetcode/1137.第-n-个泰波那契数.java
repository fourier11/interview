/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 * 
 * 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int t = 1;
        for (int i = 3; i <= n; i++) {
            t = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t;
        }
        return t;
    }
}
// @lc code=end

