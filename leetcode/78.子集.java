import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 * 
 * 回溯算法
 */

// @lc code=start
class Solution {
    private List<Integer> tmp = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int cur, int[] nums) {
        ans.add(new ArrayList<>(tmp));
        // 注意j的起始点
        for (int j = cur; j < nums.length; j++) {
            tmp.add(nums[j]);
            dfs(j + 1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end
