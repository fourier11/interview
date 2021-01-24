import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1218 lang=java
 *
 * [1218] 最长定差子序列
 */

// @lc code=start
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        // dp表示以key结尾的等差数列最后一个值，value是最大长度
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int x : arr) {
            dp.put(x, dp.getOrDefault(x - difference, 0) + 1);
            ans = Math.max(ans, dp.get(x));
        }
        return ans;
    }
}
// @lc code=end

