import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    HashMap<Integer, Boolean> used = new HashMap<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique2(int[] nums) {
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            used.put(i, false);
        }
        Arrays.sort(nums);
        dfs(nums);
        return res;
    }

    // https://zxi.mytechroad.com/blog/searching/leetcode-47-permutations-ii/
    private void dfs(int[] nums) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used.get(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used.get(i - 1)) {
                continue;
            }
            used.put(i, true);
            path.add(nums[i]);
            dfs(nums);
            path.remove(path.size() - 1);
            used.put(i, false);
        }
    }
}
// @lc code=end
