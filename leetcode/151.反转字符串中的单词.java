/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
// @lc code=end

