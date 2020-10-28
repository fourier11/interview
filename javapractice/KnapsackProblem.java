/**
 * 0-1背包问题
 * 
 * 背包中的物体不能分割，这也是0-1背包的由来
 * 
 * 参考文章：
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485064&idx=1&sn=550705eb67f5e71487c8b218382919d6&chksm=9bd7f880aca071962a5a17d0f85d979d6f0c5a5ce32c84b8fee88e36d451f9ccb3bb47b88f78&scene=21#wechat_redirect
 * 
 * 参考wiki讲解： https://zh.wikipedia.org/wiki/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98
 */
public class KnapsackProblem {
    /**
     * 0-1背包问题
     * @param N   物品的个数
     * @param W   背包能承受的最大重量
     * @param wt  各个物品的重量
     * @param val 各个物品的价值
     * @return 背包能携带的最大价值
     */
    private static int knapsack(int N, int W, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        // 注意：对于dp数组而言，i是从1开始的，w也是从1开始，所以wt和val取值要是i-1
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 当前背包容量已经装不下了，只能选择不装入背包。这个判断仅用于减少计算量。
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int[] w = { 2, 2, 6, 5, 4 }; // 物品重量
        int[] v = { 6, 3, 5, 4, 6 }; // 物品价值
        // 测试0-1背包问题模板
        int res = knapsack(5, 10, w, v);
        System.out.println("背包的最大价值为：" + res);
    }
}