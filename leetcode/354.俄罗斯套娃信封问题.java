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
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
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
}
// @lc code=end

