import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = res.get(res.size() - 1);
            // 第一个判断似乎无用
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            } else if (cur[0] > last[1]) {
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end
