/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {

    public int[] sortArray(int[] nums) {
        int[] helper = new int[nums.length];
        mergeSort(nums, helper, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] helper, int low, int high) {
        if (low == high) {
            return;
        }
        int middle = low + (high - low) / 2;
        mergeSort(nums, helper, low, middle);
        mergeSort(nums, helper, middle + 1, high);
        merge(nums, helper, low, high, middle);
    }

    private void merge(int[] nums, int[] helper, int low, int high, int middle) {
        for (int i = low; i <= high; i++) {
            helper[i] = nums[i];
        }

        int i = low;
        int j = middle + 1;
        for (int p = low; p <= high; p++) {
            if (i == middle + 1) {
                nums[p] = helper[j++];
            } else if (j == high + 1) {
                nums[p] = helper[i++];
            } else if (helper[i] > helper[j]) {
                nums[p] = helper[j++];
            } else {
                nums[p] = helper[i++];
            }
        }
    }
}
// @lc code=end
