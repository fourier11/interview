/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 * 解法：
 * 采用快排思路
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while(l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int h) {
        int i = l;
        int j = h + 1;
        while(true) {
            // 把首个元素作为pivot
            while(a[++i] < a[l] && i < h);
            while(a[--j] > a[l] && j > l);
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
// @lc code=end

