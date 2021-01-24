/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 * 
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * https://zxi.mytechroad.com/blog/leetcode/leetcode-79-word-search/
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int deep, int x, int y) {
        if (x < 0 || x == board.length || y < 0 || y == board[0].length || word.charAt(deep) != board[x][y]) {
            return false;
        }
        if (deep == word.length() - 1) {
            return true;
        }
        char cur = board[x][y];
        // 这里相当于标记x,y这个位置已经用过了。避免额外申请一个used数组
        board[x][y] = '*';
        boolean found = search(board, word, deep + 1, x + 1, y) 
                        || search(board, word, deep + 1, x - 1, y) 
                        || search(board, word, deep + 1, x, y + 1)
                        || search(board, word, deep + 1, x, y - 1);
        board[x][y] = cur;
        return found;
    }
}
// @lc code=end

