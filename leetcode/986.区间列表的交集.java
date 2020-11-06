import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 * 
 * https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie-qing-an-shun-xu-yue-du/qu-jian-wen-ti-he-ji
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < A.length && j < B.length) {
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];
            if (b2 >= a1 && a2>= b1) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            // 注意移动指针是以后半部分边界为准
            if (a2 < b2) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end

