/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 * 
 * 差分数组题型，默认长度为n的数组，每个元素都是0，就容易理解了。
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference df = new Difference(nums);
        for (int[] booking : bookings) {
            // 转成数组索引需要减1，因为航班编号是从1开始，而不是0
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            df.increment(i, j, val);
        }
        return df.result();
    }


    class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
// @lc code=end

