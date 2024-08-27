/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // nums2大顶堆
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
            (int[] pair1, int[] pair2) -> {
                return pair2[1] - pair1[1];
            }
        );
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }
        // nums1 升序排序
        Arrays.sort(nums1);

        int left = 0;
        int right = n - 1;
        int[] res = new int[n];
        
        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            int i = pair[0];
            // maxval是nums2中的最大值，i是对应索引
            int maxval = pair[1];
            if (maxval < nums1[right]) {
                // 如果nums1[right]能胜过maxval,就自己上
                res[i] = nums1[right];
                right--;
            } else {
                // 否则用最小值混一下
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
// @lc code=end

