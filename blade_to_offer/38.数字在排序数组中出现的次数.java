
/**
 * 统计一个数字在排序数组中出现的次数。
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
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        if ((left < nums.length && nums[left] != target) || left >= nums.length) {
            return -1;
        }
        return left;
    }

    private int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if ((right >= 0 && nums[right] != target) || right < 0) {
            return -1;
        }
        return right;
    }
}