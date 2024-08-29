
/**
 * 统计一个数字在排序数组中出现的次数。
 * 
 * 二分查找左右边界问题
 */
class Solution {
    public int search(int[] nums, int target) {
        int right = rightBound(nums, target);
        int left = leftBound(nums, target);
        if (left == -1 || right == -1) {
            return 0;
        }
        return right - left + 1;
    }

    
    private int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        // right 不包含进去，所以不能是nums.length - 1
        int right = nums.length;
        // 左闭右开写法
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                right = mid;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    private int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        // 左闭右开写法
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1: -1;
    }
}