/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 * 
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */

// @lc code=start
class Solution {
    // 暴力解法,会出现超时。222/231 cases passed (N/A)
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if ((j - i + 1) % 2 == 1) {
                    continue;
                }
                if (isValid(s.substring(i, j+1))) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // 动态规划解法 
    public int longestValidParentheses2(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i == 1) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                    }
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i-1] < 2) {
                        dp[i] = dp[i-1] + 2;
                    } else {
                        // 注意后半段，需要考虑 i - dp[i - 1] - 1之前是否还存在有效的括号串
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    // 
    /**
     * 栈解决法,栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
     * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
     * 对于遇到的每个 ‘)’，我们先弹出栈顶元素表示匹配了当前右括号：
     * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     * 
     * 这道题看似用stack非常容易，实际在使用中，有很多反逻辑的点。比如stack存放的居然不是char，而是index
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        // 注意这里的-1是为了应对第一个字符为左括号的情况
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParentheses4(String s) {
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

