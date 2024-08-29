/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 * 
 * 二分搜索题型，
 * 
 * 和1011题 D天内送达包裹能力，几乎就是同一道题。
 * 
 * 只是问法不同
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        // right 是开区间，初始值+1
        int right = 1;
        for (int w : nums) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(nums, mid) == k) {
                right = mid;
            } else if (f(nums, mid) < k) {
                right = mid;
            } else if (f(nums, mid) > k) {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 
     * @param nums
     * @param x 表示各自和的最大值
     * @return 需要多少个子数组
     */
    private int f(int[] nums, int x) {
        int res = 0;
        int i = 0;
        while (i < nums.length) {
            int cap = x;
            while (i < nums.length) {
                if (cap < nums[i]) {
                    break;
                } else {
                    cap -= nums[i];
                    i++;
                }
            }
            res++;
        }
        return res;
    }

}
// @lc code=end

