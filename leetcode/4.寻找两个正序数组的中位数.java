/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数.
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * 
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */

// @lc code=start
class Solution {
    /**
     * 暴力解法
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0 && n == 0) {
            return 0;
        }
        int[] nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        int curr = 0;
        int i = 0;
        int j = 0;
        while (curr != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[curr++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[curr++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[curr++] = nums1[i++];
            } else {
                nums[curr++] = nums2[j++];
            }
        }

        if (curr % 2 == 0) {
            return (nums[curr / 2] + nums[curr / 2 - 1]) / 2.0;
        } else {
            return nums[curr / 2];
        }
    }

    /**
     * 第k个数解法（官方解法，index操作要小心）
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        if (total % 2 == 1) {
            int midIndex = total / 2;
            double res = getKth(nums1, nums2, midIndex + 1);
            return res;
        } else {
            int midIndex1 = total / 2 - 1;
            int midIndex2 = total / 2;
            double res = (getKth(nums1, nums2, midIndex1 + 1) + getKth(nums1, nums2, midIndex2 + 1)) / 2.0;
            return res;
        }
    }

    // 返回第k个数，注意，k是从1开始数
    private int getKth(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                // 这部分操作相当于“删去”了nums1前半段的数
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
// @lc code=end
