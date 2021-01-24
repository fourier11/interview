import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后（经典八皇后问题）
 * 回溯算法：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=21#wechat_redirect
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */

// @lc code=start
class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> board = new ArrayList<>();
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        backtrack(0);
        return res;
    }

    private void backtrack(int row) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) {
                continue;
            }
            setCharAt(row, col, 'Q');
            backtrack(row + 1);
            setCharAt(row, col, '.');
        }
    }

    private boolean isValid(int row, int col) {
        // 检查列是否有冲突
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查右上角是否有冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查左上角是否有冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void setCharAt(int row, int col, char c) {
        // String 转 StringBuilder
        StringBuilder sb = new StringBuilder(board.get(row));
        sb.setCharAt(col, c);
        board.set(row, sb.toString());
    }
}
// @lc code=end
