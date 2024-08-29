/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 * 
 * 二分搜索题型
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        // java符合，N次方必须用Math.pow, ^符号表示异或
        int right = (int) Math.pow(10,9)+ 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) == h) {
                // 搜索左边界，需要收缩右侧边界
                right = mid;
            } else if (f(piles, mid) < h) {
                right = mid;
            } else if (f(piles, mid) > h) {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 这个函数是递减函数，所以可以用二分搜索解法
     * @param piles 每堆香蕉个数
     * @param x 吃香蕉速度
     * @return 需要多少小时吃完香蕉
     */
    private long f(int[] piles, int x) {
        long hours = 0L;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }
}
// @lc code=end

