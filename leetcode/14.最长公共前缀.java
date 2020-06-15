/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int strMinLength = Integer.MAX_VALUE;
        for (String str : strs) {
            strMinLength = Math.min(strMinLength, str.length());
        }
        int i = 0;
        // 注意j在这里表示不是末尾的下标
        int j = strMinLength;
        while (i < j) {
            // 计算中间值时，需要加1
            int mid = i + (j - i + 1) / 2;
            if (isCommonPrefix(strs, mid)) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return strs[0].substring(0, i);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String strTmp = strs[i].substring(0, length);
            if (!str0.equals(strTmp)) {
                return false;
            } 
        }
        return true;
    }
}
// @lc code=end

