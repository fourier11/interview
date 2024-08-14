
/**
 * 找出数组中重复的数字。
 * 
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1（这个条件很关键）
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */

class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    /**
     * 方案二：时间复杂度O(N),空间复杂度O(N)
     */
    public int findRepeatDocument(int[] documents) {
        Set<Integer> hmap = new HashSet<>();
        for (int doc : documents) {
            if (hmap.contains(doc))
                return doc;
            hmap.add(doc);
        }
        return -1;
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}