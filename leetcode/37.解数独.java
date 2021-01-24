import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 * 
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 */

// @lc code=start
class Solution {
    private boolean[][] line = new boolean[9][10];
    private boolean[][] column = new boolean[9][10];
    private boolean[][][] block = new boolean[3][3][10];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    // char转int，- '0'
                    int digit = board[i][j] - '0';
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for (int digit = 1; digit < 10 && !valid; digit++){
            if (!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]) {
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                // 注意int 转 char，是需要+‘0’
                board[i][j] = (char) (digit + '0');
                dfs(board, pos + 1);
                // 不需要对board回滚，因为这个位置的值没有在dfs直接使用，后续直接替换掉
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
// @lc code=end

