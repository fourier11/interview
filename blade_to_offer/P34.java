
/**
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1
 * 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 6) {
            return index;
        }
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }
        return dp[index - 1];
    }
}