import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    /**
     * BFS解法
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] input = new int[numCourses];
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        // 统计节点入度
        for (int[] edge : prerequisites) {
            input[edge[0]]++;
        }
        // 度为0的加入队列
        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            res[idx++] = temp;
            for (int[] edge : prerequisites) {
                if(edge[1] == temp) {
                    input[edge[0]]--;
                    if (input[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        // 出现环了
        if (idx != numCourses) {
            return new int[]{};
        }
        return res;
    }
}
// @lc code=end

