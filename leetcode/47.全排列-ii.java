import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        LinkedList<Integer> tracker = new LinkedList<>();
        backtrack(nums, 0, tracker);
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> tracker) {
        if (nums.length == tracker.size()) {
            res.add(new LinkedList<>(tracker));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            
            swap(nums, i, start);
            tracker.add(nums[start]);
            backtrack(nums, start + 1, tracker);
            swap(nums, i, start);
            tracker.removeLast();
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
// @lc code=end
