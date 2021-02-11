import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。两个相邻元素间的距离为 1 。
 * 
 * 说明：
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */

// @lc code=start
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    res[ni][nj] = res[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true; 
                }
            }
        }

        return res;
    }
}
// @lc code=end

