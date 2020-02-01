/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 统计所有小于非负整数 n 的质数的数量。
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            for (long j = (long) (i) * i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }
}
// @lc code=end

