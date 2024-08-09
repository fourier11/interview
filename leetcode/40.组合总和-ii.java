import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * candidates数组中包含相同的元素
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    // 记录元素之和
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        // 先排序，让相同元素靠一起
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int start, int target) {

        if (trackSum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            trackSum += nums[i];
            backtrack(nums, i + 1, target);
            trackSum -= nums[i];
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

