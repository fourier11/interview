/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c
 * 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
 * 
 * 回溯法
 * 注意，答案需要的只是其中一条路径。
 * 二维数组的值为1，表示有障碍物。
 */
class Solution {
    private List<List<Integer>> path = new LinkedList<>();
    private int r = 0;
    private int c = 0;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        if (r == 0) {
            return path;
        }
        c = obstacleGrid[0].length;
        if (obstacleGrid[r - 1][c - 1] == 1) {
            return path;
        }
        boolean[][] visited = new boolean[r][c];
        backtrack(obstacleGrid, 0, 0, visited);
        return path;
    }

    private boolean backtrack(int[][] obstacleGrid, int x, int y, boolean[][] visited) {
        if (x >= r || y >= c || obstacleGrid[x][y] == 1 || visited[x][y]) {
            return false;
        }
        path.add(Arrays.asList(x, y));
        visited[x][y] = true;
        if (x == r - 1 && y == c - 1) {
            return true;
        }
        if (backtrack(obstacleGrid, x + 1, y, visited) || backtrack(obstacleGrid, x, y + 1, visited)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}