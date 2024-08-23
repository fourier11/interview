/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    private int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(dungeon, 0, 0);
    }

    /**
     * 定义：从(i,j)到达右下角，需要的初始血量至少是多少
     */
    private int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        // base case
        if (i == m - 1 && j == n - 1) {
            // 英雄至少1滴血
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }

        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        // 备忘录，避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 状态转移逻辑
        int res = Math.min(dp(grid, i + 1, j), dp(grid, i, j + 1)) - grid[i][j];
        // 英雄至少1滴血
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }

}
// @lc code=end

