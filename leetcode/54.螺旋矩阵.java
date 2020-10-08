/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int d = 0;
        for (int i = 0; i < rows * columns; i++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= rows || ny < 0 || ny >= columns || visited[nx][ny]) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            res.add(matrix[x][y]);
            visited[x][y] = true;

            x = nx;
            y = ny;
        }
        return res;
    }
}
// @lc code=end

