import java.util.Optional;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = map.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().get();
        return res;
    }
}
// @lc code=end

