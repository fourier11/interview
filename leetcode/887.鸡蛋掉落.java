import java.util.HashMap;

import jdk.internal.util.xml.impl.Pair;

/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 * 
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层F呢
 * 
 * 参考文章：
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484675&idx=1&sn=4a4ac1c0f1279530b42fedacc6cca6e6&chksm=9bd7fb0baca0721dda1eaa1d00b9a520672dc9d5c3be762eeca869be35d7ce232922ba8e928b&scene=21#wechat_redirect
 * 
 * 动态规划题型
 */

// @lc code=start
class Solution {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        return helper2(K, N, dp);
    }

    /**
     * 这种模板方法不是最优解，当k=6.N=5000会超时，没有办法通过全部Testcase
     */
    private int helper(int K, int N, int[][] dp) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (dp[K][N] != 0) {
            return dp[K][N];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            // 在所有楼层进行尝试，取最小扔鸡蛋次数
            res = Math.min(res, Math.max(helper(K, N - i, dp), helper(K - 1, i - 1, dp)) + 1);
        }
        dp[K][N] = res;
        return res;
    }

    /**
     * 采用二分搜索优化，能通过全部用例
     */
    private int helper2(int K, int N, int[][] dp) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (dp[K][N] != 0) {
            return dp[K][N];
        }
        int lo = 1;
        int hi = N;
        while (lo + 1 < hi) {
            int x = (lo + hi) / 2;
            int t1 = helper2(K - 1, x - 1, dp);
            int t2 = helper2(K, N - x, dp);
            if (t1 < t2) {
                lo = x;
            } else if (t1 > t2) {
                hi = x;
            } else {
                lo = hi = x;
            }
        }

        // 这部分代码还没有完全理解
        int res = 1 + Math.min(Math.max(helper2(K - 1, lo - 1, dp), helper2(K, N - lo, dp)),
                Math.max(helper2(K - 1, hi - 1, dp), helper2(K, N - hi, dp)));
        dp[K][N] = res;
        return res;
    }
}
// @lc code=end
