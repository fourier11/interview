/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x的平方根
 * 
 * 二分查找衍生题
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 注意，8的平方根是2.***,相当于要返回左边界，这里 h<l,h正是左边界
        return h;
    }
}
// @lc code=end

