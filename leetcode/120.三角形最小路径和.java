import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 * 
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 
 * https://leetcode-cn.com/problems/triangle/solution/javadong-tai-gui-hua-si-lu-yi-ji-dai-ma-shi-xian-b/
 * 
 * https://www.youtube.com/watch?v=ITV2CglqkWU&feature=emb_logo
 */

// @lc code=start
class Solution {

    // public int minimumTotal2(List<List<Integer>> triangle) {
    // if (triangle == null || triangle.size() == 0) {
    // return 0;
    // }
    // int n = triangle.size();
    // int[][] dp = new int[n + 1][n + 1];
    // for (int i = n - 1; i >= 0; i--) {
    // List<Integer> rows = triangle.get(i);
    // for (int j = 0; j < rows.size(); j++) {
    // dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + rows.get(j);
    // }
    // }
    // return dp[0][0];
    // }

    /**
     * 这个方法更容易理解一些
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        // 从（1，1）开始
        int[][] dp = new int[n + 1][n + 1];
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, Integer.MAX_VALUE));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = triangle.get(i - 1).get(j - 1);
                if (i == 1 && j == 1) {
                    continue;
                }
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, dp[n][i]);
        }
        return res;
    }
}
// @lc code=end
