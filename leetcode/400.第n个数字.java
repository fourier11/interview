/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第N个数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        long num = n;
        long size = 1;
        long max = 9;
        while (n > 0) {
            if (num - max * size > 0) {
                num = num - max * size;
                size++;
                max *= 10;
            } else {
                long count = num / size;
                long left = num % size;
                if (left == 0) {
                    // 这部分计算逻辑没有完全理解
                    return (int) ((long) (Math.pow(10, size - 1) + count - 1) % 10);
                } else {
                    return (int) ((long) ((Math.pow(10, size - 1) + count) / (long) Math.pow(10, (size - left))) % 10);
                }
            }
        }
        return 0;
    }
}
// @lc code=end

