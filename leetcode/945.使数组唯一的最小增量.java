/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x : A) {
            count[x]++;
        }
        int ans = 0;
        int taken = 0;
        for(int i = 0; i < 80000; i++) {
            if (count[i] >= 2) {
                taken += count[i] - 1;
                ans -= i*(count[i] - 1);
            } else if (taken > 0 && count[i] == 0){
                taken--;
                ans += i;
            }
        }
        return ans;
    }
}
// @lc code=end

