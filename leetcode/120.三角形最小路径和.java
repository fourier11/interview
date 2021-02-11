import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 * 
 * https://leetcode-cn.com/problems/triangle/solution/javadong-tai-gui-hua-si-lu-yi-ji-dai-ma-shi-xian-b/
 */

// @lc code=start
class Solution {
    /**
     * 自底向上DP解法
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int i = n - 1; i >= 0 ; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + rows.get(j);
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

