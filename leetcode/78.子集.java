import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 
 * 回溯算法
 */

// @lc code=start
class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int begin) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new ArrayList<>(path));
        
        // 注意j的起始点
        for (int j = begin; j < nums.length; j++) {
            // 做选择
            path.add(nums[j]);
            // 通过begin参数，控制剪枝
            backtrack(nums, j + 1);
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
