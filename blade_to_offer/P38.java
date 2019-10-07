
/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int K) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}