/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 二分查找，返回左侧边界和右侧边界问题
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int[] res = new int[2];
        res[0] = leftBound(nums, target);
        res[1] = rightBound(nums, target);
        return res;
    }

    private int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 两端都闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
                // 注意这里细节，>= ,找到target时不要立即返回，而是缩小「搜索区间」的上界right
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        // 打补丁，注意数组越界问题
        if ((left < nums.length && nums[left] != target) || left >= nums.length) {
            return -1;
        }
        return left;
    }

    private int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 两端都闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 注意细节，<=
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        // 打补丁，终止条件是 left > right
        if (left - 1 < 0 || left - 1 >= nums.length || nums[left - 1] != target) {
            return -1;
        }
        return left - 1;
    }
}
// @lc code=end
