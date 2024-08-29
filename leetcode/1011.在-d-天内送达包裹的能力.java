/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) == days) {
                right = mid;
            } else if (f(weights, mid) < days) {
                right = mid;
            } else if (f(weights, mid) > days) {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 这个是单调递减函数
     * @param weights
     * @param x 运载能力
     * @return 多少天运完所有货物
     */
    private int f(int[] weights, int x) {
        int days = 0;
        int i = 0;

        while (i < weights.length) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                    i++;
                }
            }
            days++;
        }
        return days;
    }
}
// @lc code=end

