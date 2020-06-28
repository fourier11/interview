
/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 
 * 解法： 用到了归并排序
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
 */
class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] tmp = new int[len];
        return reversePairs(nums, 0, len - 1, tmp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums, left, mid, tmp);
        int rightCount = reversePairs(nums, mid + 1, right, tmp);
        if (nums[mid] < nums[mid + 1]) {
            return leftCount + rightCount;
        }
        int mergeCount = mergeAndCount(nums, left, mid, right, tmp);
        return leftCount + rightCount + mergeCount;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = tmp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}