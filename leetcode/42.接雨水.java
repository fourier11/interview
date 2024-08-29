/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    /**
     * 暴力解法,最后一个用例会超时。
     */
    public int trap2(int[] height) {
        int n = height.length;
        int res = 0;
        // 注意：左右边界是不能接雨水的
        for (int i = 1; i < n - 1 ; i++) {
            int lMax = 0;
            int rMax = 0;
            for (int j = i; j < n; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            for (int j = i; j>= 0; j--) {
                lMax = Math.max(lMax, height[j]);
            }
            res += Math.min(lMax, rMax) - height[i];
        }
        return res;
    }

    /**
     * 备忘录解法
     */
    public int trap3(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        lMax[0] = height[0];
        rMax[n-1] = height[n-1];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return res;
    }

    /**
     * 双指针解法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int res = 0;
        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }  
        }
        return res;
    }



    
}
// @lc code=end

