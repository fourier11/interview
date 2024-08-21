import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 * 
 * 单调栈问题
 */

// @lc code=start
class Solution {

    /**
     * 逆向放入栈写法
     */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            // 得到索引间距
            res[i] = stack.isEmpty() ? 0: (stack.peek() - i);
            // 将索引入栈，而不是元素
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end
