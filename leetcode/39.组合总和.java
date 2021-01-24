import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

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
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        dfs2(0, target, candidates);
        return res;
    }

    private void dfs2(int begin, int target, int[] candidates) {
        if (begin == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 跳过当前元素
        dfs2(begin + 1, target, candidates);
        // 选择当前元素
        if (target - candidates[begin] >= 0) {
            path.add(candidates[begin]);
            dfs2(begin, target - candidates[begin], candidates);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 这里candidates数组排序了，这种剪枝能减少不必要的运算
            if (candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            // 由于可以重复选择candidates的元素，递归的时候不能选择前面的元素，可以从i开始，不用是i+1
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

