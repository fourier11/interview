/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
            return false;
        }
        int n = board.length;
        HashSet<Character> row;
        HashSet<Character> col;
        HashSet<Character> block;
        for (int i = 0; i < n; i++) {
            row = new HashSet<>();
            col = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!row.contains(board[i][j])) {
                    row.add(board[i][j]);
                } else if (board[i][j] != '.') {
                    return false;
                }

                if (!col.contains(board[j][i])) {
                    col.add(board[j][i]);
                } else if (board[j][i] != '.') {
                    return false;
                }
            }
        }

        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j+= 3) {
                block = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int h = 0; h < 3; h++) {
                        if (!block.contains(board[i + k][j + h])) {
                            block.add(board[i+k][j+h]);
                        } else if (board[i+k][j+h] != '.') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

