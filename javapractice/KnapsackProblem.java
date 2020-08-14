/**
 * 0-1背包问题 背包中的物体不能分割，这也是0-1背包的由来
 * 
 * 参考文章：
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485064&idx=1&sn=550705eb67f5e71487c8b218382919d6&chksm=9bd7f880aca071962a5a17d0f85d979d6f0c5a5ce32c84b8fee88e36d451f9ccb3bb47b88f78&scene=21#wechat_redirect
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = { 2, 2, 6, 5, 4 }; // 物品重量
        int[] v = { 6, 3, 5, 4, 6 }; // 物品价值
        int c = 10; // 背包容量
        int[] x = new int[5]; // 记录物品装入情况，0表示不转入，1表示装入
        x[0] = 1; // 初始值表示第一个物品已装入背包
        int[][] m = new int[5][c + 1];// 需要维护的二维表，为了方便计算加入一列，其中第0列表示背包容量为0时背包的最大价值为0
        /*
         * 初始化第一行，即背包中装入第一件物品
         */
        for (int j = 1; j <= c; j++) {
            if (j >= w[0]) {
                m[0][j] = v[0];
            }
        }
        /*
         * 背包中依次装入其他的物品
         */
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= c; j++) {
                if (j < w[i])
                    m[i][j] = m[i - 1][j]; // 不装入背包
                else {
                    if (m[i - 1][j - w[i]] + v[i] > m[i - 1][j])
                        m[i][j] = m[i - 1][j - w[i]] + v[i]; // 选择价值较大者
                    else
                        m[i][j] = m[i - 1][j];
                }
            }
        }
        System.out.println("背包的最大价值为：" + m[w.length - 1][c]);

        // 测试0-1背包问题模板
        int res = knapsack(5, 10, w, v);
        System.out.println("模板代码背包的最大价值为：" + res);

        for (int i = 4; i >= 1; i--) {
            if (m[i][c] > m[i - 1][c]) {
                x[i] = 1; // 装入背包
                c -= w[i]; // 物品i装入背包之前背包的容量
            } else
                x[i] = 0; // 没有装入背包
        }
        System.out.print("装入背包的物品编号是：");
        for (int i = 0; i < 5; i++) {
            if (x[i] == 1)
                System.out.printf("%2d", (i + 1));
        }
    }

    /**
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
                    // 当前背包容量已经装不下了，只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }
}