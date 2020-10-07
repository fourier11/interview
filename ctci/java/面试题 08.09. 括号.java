/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 回溯法
 */
class Solution {
    private int n;
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return res;
    }

    private void dfs(int left, int right, String str) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left + 1 <= n) {
            dfs(left + 1, right, str + "(");
        }
        if (right + 1 <= left) {
            dfs(left, right + 1, str + ")");
        }
    }
}