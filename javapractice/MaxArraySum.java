/**
 * 求最大子数组之和
 * 一个有n个元素的数组，这n个元素由正数也有负数，数组中连续一个或多个元素可以组成一个连续的子数组，一个数组可能有多个这种连续
 * 的子数组，求子数组和的最大值
 */
public class MaxArraySum {
    /**
     * 蛮力法，找出所有的子数组，然后求和，取出其中的最大值,时间复杂度O(n^3)
     * @param arr
     * @return
     */
    public static int maxSubArray(int[] arr) {
        int n = arr.length;
        int maxArraySum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int thisSum = 0;
                for (int k = i; k < j; k++) {
                    thisSum += arr[k];
                }
                if (thisSum > maxArraySum) {
                    maxArraySum = thisSum;
                }
            }
        }
        return maxArraySum;
    }

    /**
     * 重复利用已经计算的子数组的和,时间复杂度O(n^2)
     * 例如Sum[i,j] = Sum[i, j-1] + arr[j] 
     * @param args
     */
    public static int maxSubArray2(int[] arr) {
        int size = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int thisSum = 0;
            for (int j = i; j < size; j++) {
                thisSum += arr[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 动态规划法
     * All[i-1]表示最大一段数组和
     * End[i-1]表示包含arr[i-1]的最大一段数组和
     * 则存在关系：All[i-1] = max{arr[i-1], End[i-1], All[i-2]}
     * 时间复杂度为O(n),空间复杂度为O(n)
     * @param arr
     * @return
     */
    public static int maxSubArray3(int[] arr) {
        int n = arr.length;
        int[] end = new int[n];
        int[] all = new int[n];
        end[0] = all[0] = arr[0];
        for (int i = 1; i < n; i++) {
            end[i] = Math.max(end[i-1] + arr[i], arr[i]);
            all[i] = Math.max(end[i], all[i-1]);
        }
        return all[n-1];
    }

    /**
     * 优化后的动态规划
     * 每次只用到 end[i-1]与all[i-1]，可以用一个变量代替
     * 这样可以降低空间复杂度
     * @param arr
     * @return
     */
    public static int maxSubArray4(int[] arr) {
        int n = arr.length;
        int nAll = arr[0];
        int nEnd = arr[0];
        for (int i = 1; i < n; i++) {
            nEnd = Math.max(nEnd + arr[i], arr[i]);
            nAll = Math.max(nEnd, nAll);
        }
        return nAll;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 4, 8, -4, 7, -1, -5};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray2(arr));
        System.out.println(maxSubArray3(arr));
    }

}