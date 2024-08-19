/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 * 
 * 差分数组题型
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 题目有限制车站最多1001个
        int[] nums = new int[1001];
        Difference df = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            // 第trip[2]站，乘客已经下车，乘客在车上的区间是[trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            df.increment(i, j, val);
        }

        int[] res = df.result();

        for (int i = 0; i < res.length; i++) {
            if (capacity < res[i]) {
                return false;
            }
        }
        return true;
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

