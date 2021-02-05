/**
 * 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * 
 * 注意：本题相对原题稍作改动
 */
class Solution {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp0 = Math.max(dp0, dp1);
            int tmp1 = dp0 + nums[i];

            dp0 = tmp0;
            dp1 = tmp1;
        }
        return Math.max(dp0, dp1);
    }
}