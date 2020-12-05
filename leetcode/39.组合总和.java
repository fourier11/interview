import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取
 * 
 * 回溯算法
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, target, candidates);
        return res;
    }

    private void dfs(int begin, int target, int[] candidates) {
        if (begin == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 跳过
        dfs(begin + 1, target, candidates);
        // 选择
        if (target - candidates[begin] >= 0) {
            path.add(candidates[begin]);
            dfs(begin, target - candidates[begin], candidates);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

