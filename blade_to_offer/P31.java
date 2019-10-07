
/**
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int greatestsum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            sum = sum <= 0 ? val : sum + val;
            greatestsum = Math.max(greatestsum, sum);
        }
        return greatestsum;
    }
}