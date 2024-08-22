import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 * 
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 
 * 等同于https://leetcode-cn.com/problems/circus-tower-lcci/
 * 面试题 17.08. 马戏团人塔
 * 
 * 动态规划
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 按照宽度升序排列，如果宽度一样，则按照高度降序排列
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] tmp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            tmp[i] = envelopes[i][1];
        }
        return lengthOfLIS(tmp);
    }

    private int lengthOfLIS(int[] nums) {
        // 注意这里dp数组的含义，dp数组是单调递增的，dp[i]表示单调递增数组的最后一个元素
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = - (i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        } 
        return len;
    }

    /**
     * 最长递增子序列，同样解法
     * 题目编号: 300.最长上升子序列 LIS
     * 
     * 这种解法，部分用例会超时
     */
    private int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
// @lc code=end

