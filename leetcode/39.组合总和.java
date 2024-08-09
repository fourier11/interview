import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取
 * 
 * 回溯算法
 * 
 * https://www.bilibili.com/video/BV1gb411u7dy
 * 
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。(所以需要个begin，相对位置是确定的)
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    // 记录回溯的路径
    private LinkedList<Integer> path = new LinkedList<>();

    private int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (target == trackSum) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (trackSum > target) {
            // 剪枝，提高效率
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            path.add(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, i, target);
            // 撤销选择 candidates[i]
            trackSum -= candidates[i];
            path.removeLast();
        }
    }
}
// @lc code=end

