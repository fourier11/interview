import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换,凑硬币
 * 
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */

// @lc code=start
class Solution {
    private HashMap<Integer, Integer> mem = new HashMap<>();

    public int coinChange2(int[] coins, int amount) {
        return helper(coins, amount);
    }
    /**
     * 自上而下动态规划
     */
    private int helper(int[] coins, int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = helper(coins, n - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        if (res == Integer.MAX_VALUE) {
            mem.put(n, -1);
        } else {
            mem.put(n, res);
        }
        return mem.get(n);
    }

    /**
     * 自底而上动态规划，类似于0-1背包问题，逐步提升背包容量
     */
    public int coinChange(int[] coins, int amount) {
        // dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
// @lc code=end
