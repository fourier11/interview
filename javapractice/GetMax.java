
/**
 * 数组中一个数字减去它右边子数组的一个数字可以得到一个差值，求所有可能差值的最大值
 */
public class GetMax {
    /**
     * 蛮力法
     * @param arr
     * @return
     */
    public static int getMax(int[] arr) {
        if (arr == null) {
            return Integer.MIN_VALUE;
        }
        int len = arr.length;
        if (len <= 1) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (arr[i] - arr[j] > max) {
                    max = arr[i] - arr[j];
                }
            }
        }
        return max;
    }

    /**
     * 动态规划法
     * diff[i] 是以数组第i个数位减数的所有数对之差的最大值
     * max[i] 是前i+1个数的最大值
     * diff[i+1] = max{diff[i], max[i-1] - a[i]}
     * max[i+1] = max{max[i], a[i+1]}
     * @param arr
     * @return
     */
    public static int getMax2(int[] arr) {
        if (arr == null) {
            return Integer.MIN_VALUE;
        }
        int len = arr.length;
        if (len < 1) {
            return Integer.MIN_VALUE;
        }
        int[] diff = new int[len];
        int[] max = new int[len];
        diff[0] = 0;
        max[0] = arr[0];
        for (int i = 1; i < len; i++) {
            // 这里为了降低空间复杂度，可以把diff[i] 和 diff[i-1] 替换为int diff 变量
            diff[i] = Math.max(diff[i-1], max[i-1] - arr[i]);
            max[i] = Math.max(max[i-1], arr[i]);
        }
        return diff[len - 1];
    }

    public static void main(String[] args) {
        int[] a = {1,4,17,3,2,9};
        System.out.println(getMax(a));
        System.out.println(getMax2(a));
    }
}