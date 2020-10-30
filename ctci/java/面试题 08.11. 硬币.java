/**
 * 凑硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * 零钱兑换的另一个变种
 * 完全背包问题。非常经典的动态规划题型
 */
class Solution {
    public int waysToChange(int n) {

        int[] dp = new int[n + 1];

        int[] coins = new int[] { 1, 5, 10, 25 };

        // 刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        // dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;

        // dp方程：dp[i] += dp[i - coin];
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }

        return dp[n];
    }
}
