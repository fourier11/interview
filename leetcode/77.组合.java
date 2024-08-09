import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 回溯算法题型
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        backtrack(n, k, 1);
        return res;
    }

    private void backtrack(int n, int k, int start) {
        // base case
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            // 通过start参数，控制树枝的遍历，避免产生重复子集
            backtrack(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

