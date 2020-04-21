import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 * 参考：https://mp.weixin.qq.com/s/XVnoX-lBzColVvVXNkGc5g
 * 性质：1.一个「合法」括号组合的左括号数量一定等于右括号数量
 *      2.对于一个「合法」的括号字符串组合p，必然对于任何 0 <= i < len(p)都有：子串p[0..i]中左括号的数量都大于或等于右括号的数量。
 */

// @lc code=start
class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", 0, 0, n, res);
        return res;
    }

    private void dfs(String curString, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curString);
        }

        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(curString + '(', left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curString + ')', left, right + 1, n, res);
        }
    }
}
// @lc code=end

