import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 先按照起点升序排序，若起点相同，则按照终点降序排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++){
            int[] interval = intervals[i];
            if (left <= interval[0] && interval[1] <= right) {
                res++;
            } else if (interval[0] <= right && interval[1] >= right) {
                right = interval[1];
            } else if (right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - res;
    }
}
// @lc code=end

