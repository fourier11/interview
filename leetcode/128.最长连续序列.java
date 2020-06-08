import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longStack = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int currentLength = 1;
                while (set.contains(current + 1)) {
                    current++;
                    currentLength++;
                }
                longStack = Math.max(longStack, currentLength);
            }

        }
        return longStack;
    }
}
// @lc code=end

