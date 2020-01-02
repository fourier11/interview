import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> tmp1 = new HashSet<>();
        for (Integer n : nums1) {
            tmp1.add(n);
        }
        HashSet<Integer> tmp2 = new HashSet<>();
        for (Integer n : nums2) {
            tmp2.add(n);
        }
        tmp1.retainAll(tmp2);
        int[] ans = new int[tmp1.size()];
        int idx = 0;
        for (Integer entry : tmp1) {
            ans[idx++] = entry.intValue();
        }
        return ans;
    }
}
// @lc code=end

