import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 * 
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 */

// @lc code=start
class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 0 || n < 0) {
            return res;
        }
        // 只包含1~9，注意不能从0开始
        dfs(k, n, 1);
        return res;
    }

    private void dfs(int k, int n, int begin) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = begin; i <= 9; i++) {
            path.add(i);
            dfs(k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

