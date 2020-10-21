/**
 * KMP算法相关示例
 * 
 * 参考文章：
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484731&idx=2&sn=d9d6b24c7f94d5e43e08666e82251984&chksm=9bd7fb33aca0722548580dd27eb49880dc126ef87aeefedc33aa0f754f54691af6b09b41f45f&scene=21#wechat_redirect
 */
public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符]=下一个状态
        dp = new int[M][256];

        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                // 状态回退，委托 X 计算重启位置
                dp[j][c] = dp[X][c];
            }
            // 状态推进，如果遇到的字符c和pat[j]匹配，状态就应该向前推进一个, 即 next = j + 1
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影子状态，注意，X总是落后j一个状态
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 当前状态是j，遇到字符txt[i],计算下一个状态
            j = dp[j][txt.charAt(i)];
            if (j == M) {
                return i - M + 1;
            }
        }
        return -1;
    }

    /**
     * 暴力解法
     * 
     * @param pat 模式串
     * @param txt 文本串
     * @return 匹配到字符串的左侧索引
     */
    private static int searchSlow(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    break;
                }
            }
            // pat全部匹配上
            if (j == M) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("aaab");
        int pos1 = kmp.search("aaacaaab");
        int pos2 = kmp.search("aaaaaaab");
        int pos3 = searchSlow("aaab", "aaacaaab");
        System.out.println("pos1=" + pos1 + ", pos2=" + pos2 + ", pos3=" + pos3);
    }

}