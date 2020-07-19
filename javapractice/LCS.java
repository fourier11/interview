/**
 * 动态规划，求最长公共子序列的长度（注意，不同于求最长公共子串的长度） 公共子序列不需要保证连续position
 * https://www.techiedelight.com/longest-common-subsequence/
 * 
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484486&amp;idx=1&amp;sn=0bdcb94c6390307ea32427757ec0072c&source=41#wechat_redirect
 * 
 * 参考leetcode 1143
 */
class LCS {

    /**
     * 下面的方案是最基础的方案，也是效率最低的方案，递归解法。
     * @param X
     * @param Y
     * @param m 表示序列尾指针，开区间，实际就是 X[0..m-1]
     * @param n Y[0..n-1]
     */
    public static int LCSLength(String X, String Y, int m, int n) {
        // return if we have reached the end of either sequence
        if (m == 0 || n == 0) {
            return 0;
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return LCSLength(X, Y, m - 1, n - 1) + 1;
        }

        // else if last character of X and Y don't match
        return Integer.max(LCSLength(X, Y, m, n - 1), LCSLength(X, Y, m - 1, n));
    }

    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";

        System.out.print("The length of LCS is " + LCSLength(X, Y, X.length(), Y.length()));
    }
}
