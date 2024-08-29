/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 * 
 * 暂时跳过
 */

// @lc code=start

import java.util.Deque;

class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        // 只有小写字母,表示每个字符最后出现的下标
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<Character>();
        // 在栈中是否出现
        boolean[] visited = new boolean[26];

        for (int i = 0; i < len; i++) {
            if (visited[charArray[i] - 'a']) {
                // 如果栈中存在，可以直接跳过这个字符
                continue;
            }
            
            // 表示含义栈顶元素序列大于当前元素，并且当前元素在后面也出现过，就可以把栈顶元素移除
            while (!stack.isEmpty() 
            && stack.peekLast() > charArray[i]
            && lastIndex[stack.peekLast()- 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }

            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            // 从栈底到栈顶的输出
            sb.append(ch);
        }
        return sb.toString();
    }
}
// @lc code=end

