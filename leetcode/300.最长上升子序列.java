import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 * [300] 最长上升子序列 LIS
 * 
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * 
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484498&amp;idx=1&amp;sn=df58ef249c457dd50ea632f7c2e6e761&source=41#wechat_redirect
 * 
 * https://www.bilibili.com/video/BV1Wf4y1y7ou/
 */

// @lc code=start
class Solution {
    /**
     * DP + Greedy + Binary Search
     * 时间复杂度 O(nlogn)
     * 
     * Patience sorting
     */
    public int lengthOfLIS(int[] nums) {
        // dp数组是单调递增的，所以可以二分查找。dp[i]表示单调递增子序列当它的长度是i+1，最小的尾数。对于相同的长度，它是不断变小。dp初始值为0
        int[] dp = new int[nums.length];
        // 表示dp数组实际有效长度
        int len = 0;
        for (int num : nums) {
            // 当没有找到时，返回-(<i>insertion point</i>) - 1
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    /**
     * 时间复杂度是O(n^2)
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
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
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

