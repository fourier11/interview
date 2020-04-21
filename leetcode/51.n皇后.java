import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
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
        for(int col = 0; col < n; col++) {
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
        for (int i = row - 1,j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查左上角是否有冲突
        for (int i = row - 1, j = col - 1; i >=0 && j>=0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void setCharAt(int row, int col, char c) {
        StringBuilder sb = new StringBuilder(board.get(row));
        sb.setCharAt(col, c);
        board.set(row, sb.toString());
    }
}
// @lc code=end

