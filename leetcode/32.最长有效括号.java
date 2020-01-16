/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (sArr[i] == ')' && stack.size() > 1 && sArr[stack.peek()] == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }
}
// @lc code=end

